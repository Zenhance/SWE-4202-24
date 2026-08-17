package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;
public abstract class CatalogItem implements Chargeable
{
    private final String sku;
    private final String title;
    private final long unitPrice;
    private long stock;
    private final Seller seller;

    protected CatalogItem(String sku, String title, long unitPrice, long stock, Seller seller)
    {
        if(sku == null || sku.isBlank())
        {
            throw new IllegalArgumentException("sku must not be blank");
        }
        if(title == null || title.isBlank())
        {
            throw new IllegalArgumentException("title must not be blank");
        }
        if(unitPrice < 0)
        {
            throw new IllegalArgumentException("unitPrice must be >= 0");
        }
        if(stock < 0)
        {
            throw new IllegalArgumentException("stock must be >= 0");
        }
        if(seller == null)
        {
            throw new IllegalArgumentException("seller must not be null");
        }
        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.seller = seller;
    }

    public String sku()
    {
        return sku;
    }

    public String title()
    {
        return title;
    }

    public long unitPrice()
    {
        return unitPrice;
    }

    public long remaining()
    {
        return stock;
    }

    public Seller seller()
    {
        return seller;
    }

    public abstract long commissionOn(long lineValue);

    @Override
    public long unitCharge()
    {
        return unitPrice;
    }

    @Override
    public String label()
    {
        return title;
    }

    public boolean hasStock(long quantity)
    {
        return quantity <= stock;
    }

    public void reserve(long quantity) throws OutOfStockException
    {
        if(quantity <= 0)
        {
            throw new IllegalArgumentException("quantity must be positive");
        }
        if(!hasStock(quantity))
        {
            throw new OutOfStockException("Not enough stock of " + sku + " to reserve " + quantity + " unit(s)");
        }
        stock -= quantity;
    }
}