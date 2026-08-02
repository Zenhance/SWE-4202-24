package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable{
    private final String sku;
    private final String title;
    private final long unitPrice;
    private int remainingStock;
    private final Seller seller;

    public Catalogitem(String sku,String title,long unitPrice, int initialStock, Seller seller) {
        if(sku==null || sku.trim().isEmpty()) throw new IllegalArgumentException();
        if(title==null || title.trim().isEmpty()) throw new IllegalArgumentException();
        if(unitPrice<0 || initialStock<0 || seller==null) throw new IllegalArgumentException();
        this.sku=sku;
        this.title=title;
        this.unitPrice=unitPrice;
        this.remainingStock=initialStock;
        this.seller=seller;
    }
}
