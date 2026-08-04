package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;
import kenakata.settlement.Seller;

public abstract class CatalogItem implements Chargeable {
    public String sku;
    public static String title;
    public final long unitPrice;
    public final Seller seller;
    private int stock_count;

    protected CatalogItem(String sku, String title , long unitPrice, int stock, Seller seller){
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

    public static String title() {
        return title;
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
    public abstract long commissionOn(long lineValue);


    public abstract int remaining();

    public abstract String sku();


}
