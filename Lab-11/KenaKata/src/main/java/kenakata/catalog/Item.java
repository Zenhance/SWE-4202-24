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
    public long unitCharge() {
        return unitPrice;
    }

    @Override
    public abstract long unitVat();

    @Override
    public abstract long commissionOn(long amount);
}