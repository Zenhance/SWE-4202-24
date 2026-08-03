package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class AbstractItem implements Item {
    private String sku;
    private String title;
    private long unitPrice;
    private int stock;
    private Seller seller;
}