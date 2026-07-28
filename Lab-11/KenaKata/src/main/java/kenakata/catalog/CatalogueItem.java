package kenakata.catalog;

import kenakata.settlement.Seller;

public abstract class CatalogueItem implements OrderableLine{
    private final String sku;
    private final String title;
    private final double unitprice;
    private int LiveStockCount;
    private final Seller seller;


    public CatalogueItem(String sku, String title, double unitprice,int LiveStockCount,Seller seller) {
        this.sku = sku;
        this.title = title;
        this.unitprice = unitprice;
        this.seller = seller;
    }

}
