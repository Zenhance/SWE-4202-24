package kenakata.catalog;
import kenakata.order.ColdChain;
import kenakata.order.Insurable;
import kenakata.order.Returnable;
import kenakata.order.Weighable;

public class FreshGood extends CatalogItem implements Weighable,ColdChain,Insurable,Returnable {
    private final int weightGrams;

    public FreshGood(String sku, String title, long unitPrice, int stock, Seller seller, int weightGrams) {
        super(sku, title, unitPrice, stock, seller,title,(double)unitPrice);
        if (weightGrams <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.weightGrams = weightGrams;
    }
    @Override
    public long unitVat(){

        return 0; //returns 0 tk bc basic food items, fresh agri product
    }
    @Override
    public long commissionOn(long amount){

        return (long)Math.ceil(amount*0.05);//5% platform commission
    }
    @Override
    public int weightGrams(){

        return weightGrams; //mainly returns to use for heavy packages
    }
    @Override
    public long coldChainSurcharge(){

        return 50; //refrigeration surcharge
    }
    @Override
    public long insurableValue(){
        return (long) unitCharge(); //if items gets damaged,returns the full unit price
    }
    @Override
    public int returnWindowDays(){
        return 2; //restricts the return period to 2 days
    }
}
