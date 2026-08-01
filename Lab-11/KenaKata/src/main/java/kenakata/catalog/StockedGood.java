package kenakata.catalog;

import kenakata.order.Returnable;
import kenakata.order.Insurable;
import kenakata.order.Weighable;
import kenakata.settlement.Seller;

public abstract class StockedGood extends CatalogItem implements Weighable, Returnable {
    private final int weightGrams;
    public StockedGood(String sku, String title, long unitPrice,Seller seller,int weightGrams){
        super(sku,title,unitPrice,stock,seller);
        if(weightGrams<=0){
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.weightGrams=weightGrams;
    }
    @Override
    public long unitVat(){
        return (long) Math.ceil(unitCharge()*0.075);
    }
    @Override
    public long commisionOn(long amount){
        return (long) Math.ceil(amount*0.08);
    }
    @Override
    public int weightGrams(){
        return weightGrams;
    }
    @Override
    public long insurableValue(){
        return unitCharge();
    }
    @Override
    public int returnWindowDays(){
        return 7;
    }
}
