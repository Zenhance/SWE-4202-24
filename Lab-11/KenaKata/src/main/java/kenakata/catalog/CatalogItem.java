package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable{
    private String SKU;
    private String title;
    private double unitPrice;
    private int stockCount;
    private Seller seller;
    private boolean isInsured;

    public CatalogItem(String SKU, String title, double unitPrice, int stockCount, Seller seller) {
        this.SKU = SKU;
        this.title = title;
        this.unitPrice = unitPrice;
        this.stockCount = stockCount;
        this.seller = seller;
        isInsured = false;
    }

    public abstract int unitCharge();

    public abstract int unitVat();

    // fix parameter
    public abstract int commissionOn(int something);

    public String getSKU() {
        return SKU;
    }

    public String getTitle() {
        return title;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getStockCount() {
        return stockCount;
    }

    public Seller getSeller() {
        return seller;
    }

    public int remaining() {
        return stockCount;
    }

    public void reserve(int quantity) throws Exception {
        if(quantity > remaining())
            throw new OutOfStockException("Out of stock");
        if (quantity <= 0)
            throw new IllegalArgumentException("Cannot reserve non-positive quantity");
        stockCount -= quantity;
    }

    public void insure() {
        isInsured = true;
    }
}