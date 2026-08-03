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
            throw new IllegalArgumentException("sku must not be null or blank");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title must not be null or blank");
        }
        if (unitPrice < 0) {
            throw new IllegalArgumentException("unitPrice must not be negative");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("stock must not be negative");
        }
        if (seller == null) {
            throw new IllegalArgumentException("seller must not be null");
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

    public Seller seller() {
        return seller;
    }

    public int remaining() {
        return stock;
    }
}