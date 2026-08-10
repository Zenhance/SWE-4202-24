package main.java.kenakata.catalog;

import main.java.kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements main.java.kenakata.catalog.Chargeable {
    private String sku;
    private String title;
    private long unitPrice;
    private int stock;
    private main.java.kenakata.catalog.Seller seller;

    public CatalogItem(String sku, String title, long unitPrice, int stock, main.java.kenakata.catalog.Seller seller){

        if(sku==null || sku.isBlank()){
            throw new IllegalArgumentException("sku cannot be null");
        }
        if(title==null || title.isBlank()){
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
        if(seller==null){
            throw new IllegalArgumentException("Seller cannot be null");
        }
        if(unitPrice<0){
            throw new IllegalArgumentException("unit price cannot be negative");
        }
        if(stock<0){
            throw new IllegalArgumentException("Stock cannot be negative");
        }

        this.sku=sku;
        this.title=title;
        this.unitPrice=unitPrice;
        this.stock=stock;
        this.seller=seller;
    }

    public String getSku(){
        return sku;
    }
    public String getTitle(){
        return title;
    }
    public long getUnitPrice(){
        return unitPrice;
    }
    public main.java.kenakata.catalog.Seller getSeller(){
        return seller;
    }
    public int getRemaining(){
        return stock;
    }

    public void reserve(int quantity) throws OutOfStockException{
        if(quantity<=0){
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if(quantity>stock){
            throw new OutOfStockException("Not enough stock available" +sku);
        }
        stock-=quantity;
    }

    public final String label(){
        return title;
    }
}
