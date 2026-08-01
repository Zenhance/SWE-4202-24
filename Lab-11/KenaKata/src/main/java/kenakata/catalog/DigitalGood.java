package kenakata.catalog;
import kenakata.settlement.Seller;

public abstract class DigitalGood extends CatalogItem {
    public DigitalGood(String sku, String title, long unitPrice,int Stock, Seller seller){
        super(sku,title,unitPrice,stock,seller);
    }
    @Override
    public long unitVat(){
        return (long) Math.ceil(unitCharge()*0.05);
    }
    @Override
    public long commissionOn(long amount){
        return (long) Math.ceil(amount*0.20);
    }
}
