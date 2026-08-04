package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable {
    private final String sku;
    private final String name;
    private final long unitPrice;
    private int stock;
    private final Seller seller;

    protected CatalogItem(String sku, String name, long unitPrice, int stock, Seller seller) {
        if (sku == null || sku.trim().isEmpty()) {
            throw new IllegalArgumentException("SKU cannot be null or empty.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be null or empty.");
        }
        if (unitPrice < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative.");
        }
        if (seller == null) {
            throw new IllegalArgumentException("Seller cannot be null.");
        }
        this.sku = sku;
        this.name = name;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.seller = seller;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public int remaining() {
        return stock;
    }

    public Seller getSeller() {
        return seller;
    }

    @Override
    public long unitCharge() {
        return unitPrice;
    }

    public void reserve(int quantity) throws OutOfStockException {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Reservation quantity must be positive.");
        }
        if (quantity > stock) {
            throw new OutOfStockException("Insufficient stock to reserve.");
        }
        stock -= quantity;
    }

    public abstract long commissionOn(long lineValue);
    public abstract int returnWindow();
    public abstract boolean isReturnable();
    public abstract boolean isInsurable();
}


