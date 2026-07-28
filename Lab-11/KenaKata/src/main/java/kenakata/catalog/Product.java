package kenakata.catalog;

import kenakata.exceptions.InsufficientStockException;

public abstract class Product {
    private String sku;
    private String title;
    private double unitPrice;
    private int stock;
    private Seller seller;

    public Product(String sku, String title, double unitPrice, int stock, Seller seller) throws InsufficientStockException {
        if (sku == null || title == null || seller == null) {
            throw new IllegalArgumentException("SKU, title and seller can not be blank.");
        }

        if (unitPrice < 0) {
            throw new IllegalArgumentException("Unit price must be positive.");
        }

        if (stock <= 0) {
            throw new InsufficientStockException("Stock must be greater than zero.");
        }

        this.sku = sku;
        this.title = title;
        this.stock = stock;
        this.seller = seller;
    }

    public String getSku() { return sku;}
    public String getTitle() { return title;}
    public int getStock() { return stock;}
    public double getUnitPrice() { return unitPrice;}
    public Seller getSeller() { return seller;}

    public int remaining() { return stock;}
    public void reserve(int quantity) throws InsufficientStockException {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        if (quantity > stock) {
            throw new InsufficientStockException("Not enough stock for " + title +".");
        }
        this.stock -= quantity;
    }

    public void restore(int quantity) { this.stock += quantity;}


}
