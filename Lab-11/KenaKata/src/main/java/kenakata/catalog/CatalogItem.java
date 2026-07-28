package kenakata.catalog;

public abstract class CatalogItem implements Chargeable {
    private final String sku;
    private final String title;
    private final long price;
    private int stock;
    private final Seller seller;

    public CatalogItem(String sku, String title, long price, Seller seller) {
        if (sku == null || sku.isBlank() || title == null || title.isBlank() || seller == null || price < 0 || stock < 0) {
            throw new IllegalArgumentException();
        }
        this.sku = sku;
        this.title = title;
        this.price = price;
        this.seller = seller;
        this.stock = stock;
    }
}
