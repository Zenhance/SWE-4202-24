package kenakata.catalog;

public abstract class CatalogItem implements Chargeable {
private String SKU;
private String title;
private double UnitPrice;
private int Stock;
private Seller seller;

public CatalogItem(String SKU, String title, double UnitPrice, Seller seller, int Stock){
    this.SKU=SKU;
    this.title=title;
    this.UnitPrice=UnitPrice;
    this.seller=seller;
    this.Stock=Stock;
}

public double unitCharge(){
    return UnitPrice;
}
    public String sku() {
        return SKU;
    }

    public String title() {
        return title;
    }



    public Seller seller() {
        return seller;
    }

    public int remaining() {
        return Stock;
    }

}
