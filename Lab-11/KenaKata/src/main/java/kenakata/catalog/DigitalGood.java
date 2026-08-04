package kenakata.catalog;

import kenakata.settlement.Seller;
import kenakata.money.Money;
public class DigitalGood extends CatalogItem {
    private static final long VAT_PER_ML=50;
    private static final long COMMISSION_PER_ML=200;

    public DigitalGood(String sku,String title , long unitPrice, int stock,Seller seller){
        super(sku,title,unitPrice,stock,seller);
    }


    @Override
    public long unitVat(){
        return Money.ceilPerMl(unitPrice(),VAT_PER_ML);
    }

    @Override
    public long unitPrice() {
        return 0;
    }

    @Override
    public long commissionOn(long lineValue){
        return Money.ceilPerMl(lineValue,COMMISSION_PER_ML);
    }

    @Override
    public int remaining() {
        return 0;
    }

    @Override
    public String sku() {
        return "";
    }
    @Override
    public long unitCharge(){
        return 1;
    }
}
