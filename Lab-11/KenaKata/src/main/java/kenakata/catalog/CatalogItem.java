package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable{
    String SKU;
    String title;
    int unitprice;
    Seller seller;
    int stock;
    public CatalogItem(String SKU, String title, int unitprice,int stock, Seller s1) throws IllegalArgumentException {
        if(SKU==null||title==null||title==" "||unitprice<=0||s1==null) throw new IllegalArgumentException();
        if(stock<0) throw new IllegalArgumentException();
        this.SKU = SKU;
        this.title = title;
        this.unitprice = unitprice;
        this.stock = stock;
        this.seller = s1;
    }
    public abstract int unitVat() ;

    public int unitCharge() {return unitprice;}
    public void reserve(int amount) throws OutOfStockException {

            if (amount <=0)  throw new IllegalArgumentException("Amount must be positive");
            if (stock >= amount) stock -= amount;
            else throw new OutOfStockException();
            }


    public int remaining() {
        return stock;
    }

    public abstract int commissionOn(int total) ;
}


