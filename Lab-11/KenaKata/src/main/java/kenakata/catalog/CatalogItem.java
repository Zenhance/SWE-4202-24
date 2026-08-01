package kenakata.catalog;

import kenakata.order.Chargeable;

public abstract class CatalogItem implements Chargeable {
    private final String sku;
    private final String title;
    private final long unitPrice;
    private int stock;
    private final Seller seller;

    public CatalogItem(String sku,String title,long unitPrice, int stock,Seller seller){
        if(sku == null || sku.isBlank() || title == null || title.isBlank() || seller == null){
            throw new IllegalArgumentException("Invalid catalog item properties");
        }
        this.sku= sku;
        this.title= title;
        this.unitPrice= unitPrice;
        this.stock=stock;
        this.seller=seller;
    }
    public String sku(){
        return sku;
    }
    public String title(){
        return title;
    }
    public Seller seller(){
        return seller;
    }
    public int remaining(){
        return stock;
    }
}
