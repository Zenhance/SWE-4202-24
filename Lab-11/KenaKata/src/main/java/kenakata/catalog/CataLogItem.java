package kenakata.catalog;
import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem {

    protected final String sku;
    protected final String title;
    protected final long price;
    protected int stock;
    protected final Seller seller;

    public CatalogItem(String sku,String title,long price,int stock,Seller seller) {

        if (sku == null || sku.isBlank() || title == null || title.isBlank() || seller == null
                || price < 0 || stock < 0) {

            throw new IllegalArgumentException("Invalid item");
        }

        this.sku = sku;
        this.title = title;
        this.price = price;
        this.stock = stock;
        this.seller = seller;
    }


    public String sku() {
        return sku;
    }


    public String title() {
        return title;
    }


    public long unitCharge() {
        return price;
    }


    public Seller seller() {
        return seller;
    }


    public int remaining() {
        return stock;
    }


    public void reserve(int quantity)
            throws OutOfStockException {


        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be positive"
            );
        }


        if (quantity > stock) {
            throw new OutOfStockException(
                    "Not enough stock"
            );
        }

        stock -= quantity;
    }


    public abstract long unitVat();


    public abstract long commissionOn(long amount);

}