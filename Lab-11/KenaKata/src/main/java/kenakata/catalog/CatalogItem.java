package kenakata.catalog;

public abstract class CatalogItem implements Chargeable{

    String SKU,TITLE;
    int UnitePrize,StockCount;
    private final Seller seller;
    public CatalogItem(String SKU, String TITLE, int UnitPrize, int StockCount, Seller seller){
        if (SKU==null||SKU.isBlank())
            throw new IllegalArgumentException();
        if (TITLE==null||TITLE.isBlank())
            throw new IllegalArgumentException();
        if (seller==null)
            throw new IllegalArgumentException();
        if (UnitPrize<0)
            throw new IllegalArgumentException();
        if (StockCount<0)
            throw new IllegalArgumentException();
        this.SKU=SKU;
        this.TITLE=TITLE;
        this.StockCount=StockCount;
        this.UnitePrize=UnitPrize;
        this.seller=seller;
    }


    public abstract long unitCharge();
    public abstract int commissionOn();
    public abstract long unitVat();
    public abstract void reserve() ;
}
