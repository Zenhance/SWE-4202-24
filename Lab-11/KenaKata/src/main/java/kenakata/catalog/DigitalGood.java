package kenakata.catalog;

public class DigitalGood extends CatalogItem{
    public DigitalGood(String sku,String title,long unitPrice,int stock,Seller seller,int weight) {
        super(sku, title, unitPrice, stock, seller);
    }

    @Override
    public long unitVat() {
        return Math.round(unitPrice*0.05);
    }

    @Override
    public long commissionOn(long value) {
        return Math.round(value*0.20);
    }

}
