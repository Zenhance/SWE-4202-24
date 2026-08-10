package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable {
private String SKU;
private String title;
private double UnitPrice;
private int Stock;
private Seller seller;

public CatalogItem(String SKU, String title, double UnitPrice, int Stock, Seller seller){
    if (SKU == null) {
        throw new IllegalArgumentException("SKU cannot be null");
    }
    if (title == null || title.isBlank()) {
        throw new IllegalArgumentException("Title cannot be blank");
    }
    if (seller == null) {
        throw new IllegalArgumentException("Seller cannot be null");
    }
    if (UnitPrice < 0) {
        throw new IllegalArgumentException("Unit price cannot be negative");
    }
    if (Stock < 0) {
        throw new IllegalArgumentException("Stock cannot be negative");
    }
    this.SKU=SKU;
    this.title=title;
    this.UnitPrice=UnitPrice;
    this.seller=seller;
    this.Stock=Stock;
}

public long unitCharge(){
    return (long) UnitPrice;
}
    public String sku() {
        return SKU;
    }

    public String title() {
        return title;
    }



    public Seller seller() {
        return seller;
    }

    public int remaining() {
        return Stock;
    }
    public abstract long commissionOn(long lineValue);


    public void reserve(int quantity) throws OutOfStockException {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (quantity > Stock) {
            throw new OutOfStockException(
                    title + ": only " + Stock + " remaining, requested " + quantity);
        }
        Stock -=  quantity;
    }

}
