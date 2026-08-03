package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class AbstractItem implements Item {
    private String sku;
    private String title;
    private long unitPrice;
    private int stock;
    private Seller seller;

    public AbstractItem(String sku, String title, long unitPrice, int stock, Seller seller) {
        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.seller = seller;
    }
}