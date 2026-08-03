package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class AbstractItem implements Item {
    private String sku;
    private String title;
    private long unitPrice;
    private int stock;
    private Seller seller;

    public AbstractItem(String sku, String title, long unitPrice, int stock, Seller seller) {

        if (sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("SKU cannot be empty or null");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty or null");
        }
        if (seller == null) {
            throw new IllegalArgumentException("Seller cannot be null");
        }
        if (unitPrice < 0) {
            throw new IllegalArgumentException("Unit price cannot be negative");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }

        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.seller = seller;
    }

    public String sku() {
        return sku;
    }

    public String title() {
        return title;
    }

    public long unitPrice() {
        return unitPrice;
    }

    public int remaining() {
        return stock;
    }

    public Seller seller() {
        return seller;
    }

    public void reserve(int quantity) throws OutOfStockException {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (quantity > stock) {
            throw new OutOfStockException("Insufficient stock");
        }
        stock -= quantity;
    }

    @Override
    public long unitCharge() {
        return unitPrice;
    }

    @Override
    public String label() {
        return title;
    }

    public abstract long commissionOn(long lineValue);
}