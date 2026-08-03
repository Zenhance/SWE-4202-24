package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class CatalogueItem {
    protected String SKU;
    protected String title;
    protected long unitPrice;
    protected int stockCount;
    protected Seller seller;

    public String getSKU(){
        return SKU;
    }
    public String getTitle(){
        return title;
    }
    public long getUnitPrice(){
        return unitPrice;
    }
    public Seller getSeller(){
        return seller;
    }
    public int getStockCount(){
        return stockCount;
    }

    void reserve(int quantity) throws OutOfStockException {
        if(stockCount < quantity){
            throw new OutOfStockException("Not Enough Stock Available.");
        }
        if(quantity <= 0){
            throw new IllegalArgumentException("Quantity should be positive.");
        }
        stockCount -= quantity;
    }


    abstract long VAT();
    abstract double Commission();
}
