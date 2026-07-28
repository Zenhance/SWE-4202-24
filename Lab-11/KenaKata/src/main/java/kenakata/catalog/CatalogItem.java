package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable {

    private final String sku;
    private final String title;
    private final long unitPrice;
    private final Seller seller;

    private int remaining;

    protected CatalogItem(
            String sku,
            String title,
            long unitPrice,
            int stock,
            Seller seller
    ) {
        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
        this.remaining = stock;
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

    public Seller seller() {
        return seller;
    }

    public int remaining() {
        return remaining;
    }

    @Override
    public long unitCharge() {
        return unitPrice;
    }

    @Override
    public String label() {
        return title;
    }

    public void ensureAvailable(int quantity)
            throws OutOfStockException {

    }

    public void reserve(int quantity)
            throws OutOfStockException {

    }

    public abstract long commissionOn(long lineValue);

    protected static void requireLineValue(long lineValue) {
    }

    protected static void requirePositiveQuantity(int quantity) {
    }
}