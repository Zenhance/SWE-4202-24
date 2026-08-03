package kenakata.catalog;
import kenakata.exceptions.OutOfStockException;
public abstract class CatalogItem implements Chargable {

private String sku;
private String title;
private double unitPrice;
private int remaining;
private Seller seller;


    public CatalogItem(String sku, String title, double unitPrice, int remaining, Seller seller)
    {
        if (sku==null || sku.isBlank())
throw new IllegalArgumentException( "Sku can not be null");
        if (title == null || title.isBlank())
throw new IllegalArgumentException("Title can not be null");
        if(unitPrice<0)
            throw new IllegalArgumentException("Unit price must be positive");
        if(remaining<0)
            throw new IllegalArgumentException("Remaining items can not be negative");
        if(seller==null)
            throw new IllegalArgumentException("Seller can not be null");
        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
        this.remaining = remaining;
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

    public Seller seller()
    {
        return seller;
    }

    @Override
    public String label()
    {
        return title;
    }

    @Override
    public double unitCharge()
    {
        return unitPrice;
    }
    public boolean canReserve(int qty)
    {
        if(qty<=0)
        {
            throw new IllegalArgumentException("Reservation quantity must be positive");
        }
        return qty<=remaining;
    }

    public void reserve(int qty) throws OutOfStockException
    {
        if(qty<=0)
        {
            throw new IllegalArgumentException("Reservation quantity must be positive");
        }
        if(qty>remaining)
        {
            throw new OutOfStockException(label() + " has only " + remaining + " units, out of " + qty);
        }
        remaining=remaining-qty;
    }
}


