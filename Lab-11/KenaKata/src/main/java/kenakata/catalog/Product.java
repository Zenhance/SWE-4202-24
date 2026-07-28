package kenakata.catalog;

public abstract class Product {
    private String sku;
    private String title;
    private double unitPrice;
    private int stock;
    private Seller seller;

    public Product(String sku, String title, double unitPrice, int stock, Seller seller) {
        if (sku == null || title == null || seller == null) {
            throw new IllegalArgumentException("SKU, title and seller can not be blank.");
        }

        if (unitPrice < 0) {
            throw new IllegalArgumentException("Unit price must be greater than zero.");
        }

        if (stock <= 0) {

        }

        this.sku = sku;
        this.title = title;
        this.stock = stock;
        this.seller = seller;
    }
}
