package kenakata.catalog;

import kenakata.settlement.Seller;

public abstract class CatalogueItem implements OrderableLine{
    private final String sku;
    private final String title;
    private final double unitprice;
    private int LiveStockCount;
    private final Seller seller;


    public CatalogueItem(String sku, String title, double unitprice,int LiveStockCount,Seller seller) {
        if(sku==null || sku.isBlank() || title==null || title.isBlank() || seller==null){
            throw new IllegalArgumentException("MEOWWWWWWW");
        }
        if(unitprice<0 || LiveStockCount<0){
            throw new IllegalArgumentException("MEOWWWWWWW");
        }

        this.sku = sku;
        this.title = title;
        this.unitprice = unitprice;
        this.seller = seller;
    }
    public String getSku(){
        return sku;
    }
    public String getTitle(){
        return title;
    }

    public double getUnitprice() {
        return this.unitprice;
    }

    public int getLiveStockCount() {
        return this.LiveStockCount;
    }

    public Seller getSeller() {
        return this.seller;
    }
    @Override
    public String getReceiptLabel(){
        return title;
    }
    @Override
    public long getCharge(int quantity){
        return (long) (unitprice*quantity);
    }
}
