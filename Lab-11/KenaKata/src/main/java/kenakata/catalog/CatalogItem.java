package kenakata.catalog;

import kenakata.exceptions.*;

public abstract class CatalogItem{
    protected String sku;
    protected String title;
    protected long unitPrice;
    protected int stock;
    protected Seller seller;

    public CatalogItem(String sku, String title, long unitPrice, int stock, Seller seller){
        this.sku=sku;
        this.title=title;
        this.unitPrice=unitPrice;
        this.stock=stock;
        this.seller=seller;
    }
    public  void reserve(int quantity) throws OutOfStockException{
        if(quantity>stock)
            throw new OutOfStockException("Out of stock");
        stock-=quantity;
    }

}
