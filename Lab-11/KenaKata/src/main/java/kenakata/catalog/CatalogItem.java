package kenakata.catalog;

public abstract class CatalogItem implements Chargeable {
    private String sku;
    private String title;
    private long unitPrice;
    private Seller seller;
    private int stock;

    protected CatalogItem(String sku, String title, long unitPrice, int stock, Seller seller) {
        if (sku == null) {
            throw new IllegalArgumentException("SKU must not be null");
        }
        if (title == null) {
            throw new IllegalArgumentException("Title must not be null");
        }
        if (unitPrice < 0) {
            throw new IllegalArgumentException("Unit price must not be negative");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("Stock must not be negative");
        }
        if (seller == null) {
            throw new IllegalArgumentException("Seller must not be null");
        }
        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.seller = seller;
    }
}
