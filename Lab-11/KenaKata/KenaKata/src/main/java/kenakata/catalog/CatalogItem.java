package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable {
    private final String sku;
    private final String title;
    private final long unitPrice;
    private int stock;
    private final Seller seller;

    protected CatalogItem(String sku, String title, long unitPrice, int stock, Seller seller) {
        if (sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("SKU empty");
        }
        if (title == null ) {
            throw new IllegalArgumentException("Title empty");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("Stock invalid");
        }
        if (seller == null) {
            throw new IllegalArgumentException("Seller cannot be null");
        }
        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.seller = seller;
    }

    public final String sku() {
        return sku;
    }

    public final String title() {
        return title;
    }

    public final long unitPrice() {
        return unitPrice;
    }

    public final Seller seller() {
        return seller;
    }

    public final int remaining() {
        return stock;
    }

    public final boolean canReserve(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity cant be negative");
        }
        return stock >= quantity;
    }

    public final void reserve(int quantity) throws OutOfStockException {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity cant be negative");
        }
        if (quantity > stock) {
            throw new OutOfStockException("Insufficient stock for " + sku);
        }
        stock -= quantity;
    }

    @Override
    public final long unitCharge() {
        return unitPrice;
    }

    @Override
    public final String label() {
        return title;
    }

    public abstract long commissionOn(long lineValue);
}
