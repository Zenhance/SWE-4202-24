package kenakata.catalog;

public abstract class CatalogItem implements Chargeable {

    private String sku;
    private String title;
    private long unitPrice;
    private int stock;
    private Seller seller;

    public CatalogItem(String sku, String title, long unitPrice,int stock, Seller seller) {
        if (sku == null || sku.isEmpty()) {
            throw new IllegalArgumentException("sku is required");
        }
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("title is required");
        }
        if (unitPrice < 0) {
            throw new IllegalArgumentException("unitPrice cant't be negative");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("stock cant't be negative");
        }
        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
        this.seller = seller;
        this.stock = stock;
    }

    public String getSku() {
        return sku;
    }

    public String getTitle() {
        return title;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public int getStock() {
        return stock;
    }



}
