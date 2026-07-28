package kenakata.catalog;

public abstract class Product {
    private String sku;
    private String title;
    private double unitPrice;
    private int stock;
    private Seller seller;

    public Product(String sku, String title, double unitPrice, int stock, Seller seller) {

        this.sku = sku;
        this.title = title;
        this.stock = stock;
        this.seller = seller;
    }
}
