package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class Product {
    private final String sku;
    private final String title;
    private long unitPrice;
    private int stock;
    private Seller seller;

    public Product(String sku, String title, long unitPrice, int stock, Seller seller) throws OutOfStockException {
        if (sku == null || sku.isBlank() || title == null || title.isBlank() || seller == null) {
            throw new IllegalArgumentException("SKU, title and seller can not be blank.");
        }

        if (unitPrice < 0) {
            throw new IllegalArgumentException("Unit price must be positive.");
        }

        if (stock < 0) {
            throw new OutOfStockException("Stock must be greater than zero.");
        }
        this.sku = sku;
        this.title = title;
        this.stock = stock;
        this.seller = seller;
    }

    public String sku() {
        return sku;}
    public String title() {
        return title;}
    public int stock() {
        return stock;}

    public double unitPrice() {
        return unitPrice;}
    public Seller seller() {
        return seller;}

    public int remaining() { return stock;}

    public void reserve(int quantity) throws OutOfStockException {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        if (quantity > stock) {
            throw new OutOfStockException("Not enough stock for " + title +".");
        }
        this.stock -= quantity;
    }

    public void restore(int quantity) throws OutOfStockException {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        if (quantity > stock) {
            throw new OutOfStockException("Not enough stock for " + title +".");
        }

        this.stock += quantity;
    }

    public String label() { return title;}
    public long unitCharge() { return unitPrice;}

    public long commissionOn() {
        return 0;
    }
    public abstract long unitVat();

    public boolean isDiscountable() {
        return false;
    }
}
