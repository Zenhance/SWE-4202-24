package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable {
    private final long unitPrice;
    private int stock;

    protected CatalogItem(long unitPrice, int stock) {
        this.unitPrice = unitPrice;
        this.stock = stock;
    }

    @Override
    public long unitCharge() {
        return unitPrice;
    }

    public int remaining() {
        return stock;
    }

    public void reserve(int quantity) throws OutOfStockException {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Reservation must be positive");
        }

        if (quantity > stock) {
            throw new OutOfStockException();
        }

        stock -= quantity;
    }
}
