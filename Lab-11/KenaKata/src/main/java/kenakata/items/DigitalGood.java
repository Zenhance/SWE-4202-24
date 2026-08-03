package kenakata.items;

import kenakata.util.Money;
public class DigitalGood extends Item{
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
    public long comissionOn(long lineValue){
        return Money.ceilPerMl(lineValue,COMMISSION_PER_ML);
    }
}
