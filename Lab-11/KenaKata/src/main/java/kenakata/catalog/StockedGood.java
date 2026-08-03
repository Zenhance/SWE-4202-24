package kenakata.catalog;
import kenakata.order.Insurable;
import kenakata.order.Returnable;
import kenakata.order.Weighable;

public class StockedGood extends CatalogItem implements Weighable,Insurable,Returnable{
    private final int weightGrams;

    public StockedGood(String sku, String title, long unitPrice, int stock, Seller seller, int weightGrams){
        super(sku, title, unitPrice, stock, seller);
        if (weightGrams <= 0){
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.weightGrams = weightGrams;
    }
@Override
public long unitVat(){
    return (long) Math.ceil(unitCharge() * 0.075);
}
@Override
public long commissionOn(long amount){
    return (long) Math.ceil(amount * 0.08);
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
