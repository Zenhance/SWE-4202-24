package kenakata.catalog;

public abstract class CatalogItem implements Chargeable{
    String SKU;
    String title;
    int unitprice;
    Seller seller;
    public CatalogItem(String SKU, String title, int unitprice, Seller s1) {
        this.SKU = SKU;
        this.title = title;
        this.unitprice = unitprice;
        this.seller = s1;
    }
    public abstract int unitVat() ;

    public abstract int unitCharge();

    public abstract int commissionOn(int i) ;

}
