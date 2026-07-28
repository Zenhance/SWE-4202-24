package kenakata.catalog;

public abstract class CatalogItem {


    private String sku;
    private String title;
    private double unitPrice;
    private int stock;
    private Seller seller;

    public CatalogItem(String sku,String title,double unitPrice,int stock,Seller seller){

        if(sku==null || sku.isBlank())
            throw new IllegalArgumentException("null sku");
        if(title==null || title.isBlank())
            throw new IllegalArgumentException("null title");
        if(unitPrice<0) throw new IllegalArgumentException("Price must be positive");
        if(stock<0) throw new IllegalArgumentException("Stock number must be positive");
        if(seller==null) throw new IllegalArgumentException("null seller");


    }


}
