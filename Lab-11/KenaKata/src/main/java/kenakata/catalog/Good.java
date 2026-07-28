package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

import java.io.Serializable;

public abstract class Good implements Comparable{
    private String SKU;
    private String title;
    private double unitPrice;
    private int stockCount;
    private Seller seller;


    public Good(String SKU, String title, double unitPrice, int stockCount, Seller seller) {
        this.SKU = SKU;
        this.title = title;
        this.unitPrice = unitPrice;
        this.stockCount = stockCount;
        this.seller = seller;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public abstract int unitCharge();

    public abstract int unitVat();

    public String getTitle() {
        return title;
    }

    public void reserve(int quantity) throws Exception {
        if(quantity > remaining())
            throw new OutOfStockException("Out of stock");
        if (quantity <= 0)
            throw new IllegalArgumentException("Cannot reserve non-positive quantity");
        stockCount -= quantity;
    }

    public int remaining() {
        return stockCount;
    }

    public abstract int commissionOn(int something);
}
