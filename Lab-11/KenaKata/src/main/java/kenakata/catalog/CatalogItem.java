package kenakata.catalog;
import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable {


    private final String sku;
    private final String title;
    private final long unitPrice;
    private int stock;
    private final Seller seller;

    public CatalogItem(String sku, String title, long unitPrice, int stock, Seller seller) {

        if (sku == null || sku.isBlank())
            throw new IllegalArgumentException("null sku");
        if (title == null || title.isBlank())
            throw new IllegalArgumentException("null title");
        if (unitPrice < 0) throw new IllegalArgumentException("Price must be positive");
        if (stock < 0) throw new IllegalArgumentException("Stock number must be positive");
        if (seller == null) throw new IllegalArgumentException("null seller");

        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.seller = seller;
    }

    public Seller seller() {
        return seller;
    }

    public long unitPrice() {
        return unitPrice;
    }

    public String title() {
        return title;
    }

    public int remaining() {
        return stock;
    }

    public String sku() {
        return sku;
    }

    @Override
    public long unitCharge(){
        return unitPrice;
    }
    public abstract long unitVat();

    @Override
    public String label() {return title;}

    public abstract long commissionOn(long lineValue);

    public void reserve(int qty) throws OutOfStockException
    {
        if(qty<=0)
        {
            throw new IllegalArgumentException("Reservation quantity must be positive");
        }
        if(qty>stock)
        {
            throw new OutOfStockException("Out of Stock");
        }
        stock-=qty;
    }




}





