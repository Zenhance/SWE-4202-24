package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class Item implements CatalogItem {

    private String sku;
    private String title;
    private long unitPrice;
    private int stock;
    private Seller seller;

    public Item(String sku, String title, long unitPrice,
                int stock, Seller seller) {

        if (sku == null || sku.isBlank()
                || title == null || title.isBlank()
                || unitPrice < 0
                || stock < 0
                || seller == null) {

            throw new IllegalArgumentException();
        }

        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.seller = seller;
    }

    @Override
    public String sku() {
        return sku;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public long unitPrice() {
        return unitPrice;
    }

    @Override
    public Seller seller() {
        return seller;
    }

    @Override
    public int remaining() {
        return stock;
    }

    @Override
    public void reserve(int quantity) throws OutOfStockException {

        if (quantity <= 0) {
            throw new IllegalArgumentException();
        }

        if (quantity > stock) {
            throw new OutOfStockException();
        }

        stock -= quantity;
    }

    @Override
    public long unitCharge() {
        return unitPrice;
    }

    @Override
    public abstract long unitVat();

    @Override
    public abstract long commissionOn(long amount);
}