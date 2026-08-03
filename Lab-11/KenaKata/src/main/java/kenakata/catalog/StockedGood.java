package kenakata.catalog;

import kenakata.order.Returnable;
import kenakata.order.Insurable;
import kenakata.order.Weighable;
import kenakata.settlement.Seller;

public abstract class StockedGood extends CatalogItem implements Weighable, Returnable,Insurable {
    private final int weightGrams;

    public StockedGood(String sku, String title, long unitPrice,int stock,Seller seller,int weightGrams){
        super(sku,title,unitPrice,stock,seller,title,(double)unitPrice);
        if(weightGrams<=0){
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.weightGrams=weightGrams;
    }
    @Override
    public long unitVat(){

        return (long) Math.ceil(unitCharge()*0.075);//7.5% vat on unit charge
    }
    @Override
    public long commissionOn(long amount){

        return (long) Math.ceil(amount*0.08);//8% commission
    }
    @Override
    public int weightGrams(){

        return this.weightGrams;
    }
    @Override
    public long insurableValue(){

        return (long)Math.round(unitCharge());//if items gets damaged,returns the full unit price
    }
    @Override
    public int returnWindowDays(){
        return 7;//restricts the return period to 7 days
    }
}