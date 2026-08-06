package kenakata.catalog;

public abstract class CatalogItem implements Chargeable{
    String SKU;
    String title;
    int unitprice;
    Seller seller;
    public CatalogItem(String SKU, String title, int unitprice, Seller s1) throws IllegalArgumentException {
        if(SKU==null||title==null||title==" "||unitprice<=0||s1==null) throw new IllegalArgumentException();
        this.SKU = SKU;
        this.title = title;
        this.unitprice = unitprice;
        this.seller = s1;
    }
    public abstract int unitVat() ;

    public int unitCharge() {return unitprice;}

    public abstract int commissionOn(int total) ;

}
