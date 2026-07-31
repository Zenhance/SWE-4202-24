package kenakata.catalog;

public abstract class CatalogItem implements Chargable{
    private String sku;
    private String title;
    private int unitPrice;
    private int stock;
    private String seller;

    public CatalogItem(String sku, String title, int unitPrice, int stock, String seller ){
        this.sku=sku;
        this.title=title;
        this.unitPrice=unitPrice;
        this.stock=stock;
        this.seller=seller;
    }





}
