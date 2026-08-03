package kenakata.items;

import kenakata.exception.OutOfStockException;
import kenakata.settlement.Seller;

import kenakata.exception.OutOfStockException;

public abstract class Item implements Chargeable {
    private final String sku;
    private final String title;
    private final long unitPrice;
    private final Seller seller;
    private int stock_count;

    protected Item(String sku, String title ,long unitPrice,int stock,Seller seller){
        if(sku==null ||sku.isBlank()){
            throw new IllegalArgumentException("sku must not be empty");

        }
        if(title ==null||title.isBlank()){
            throw new IllegalArgumentException("title cannot be empty");
        }
        if(seller ==null){
            throw new IllegalArgumentException("Seller must not be null");
        }
        if(unitPrice<0){
            throw new IllegalArgumentException("Unitprice must not be negative");
        }
        if(stock<0){
            throw new IllegalArgumentException("stock must not be negative");
        }
        this.sku=sku;
        this.title=title;
        this.unitPrice=unitPrice;
        this.stock_count=stock;
        this.seller=seller;



    }
    public void reserve(int quantity) throws OutOfStockException{
        if(quantity<=0){
            throw new IllegalArgumentException("quantity must be positive");

        }
        if(quantity>stock_count){
            throw new OutOfStockException("only"+stock_count+" of "+sku+" remaining, cannot reserve "+quantity);
        }
        stock_count-=quantity;
    }
    @Override
    public long UnitCharge(){
        return unitPrice;
    }
    @Override
    public String label(){
        return title;
    }
    public abstract long comissionOn(long lineValue);


}
