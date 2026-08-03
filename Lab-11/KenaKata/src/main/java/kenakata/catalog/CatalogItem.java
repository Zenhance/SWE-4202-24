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
        if (SKU == null)
            throw new IllegalArgumentException("SKU cannot be null");
        if (SKU.isBlank())
            throw new IllegalArgumentException("SKU cannot be blank");
        this.SKU = SKU;

        if (title == null)
            throw new IllegalArgumentException("Title cannot be null");
        if (title.isBlank())
            throw new IllegalArgumentException("Title cannot be blank");
        this.title = title;

        if (unitPrice < 0.0)
            throw new IllegalArgumentException("Unit price cannot negative");
        this.unitPrice = unitPrice;

        if (stockCount < 0)
            throw new IllegalArgumentException("Stock count cannot be negative");
        this.stockCount = stockCount;

        if (seller == null)
            throw new IllegalArgumentException("Seller cannot be null");
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
