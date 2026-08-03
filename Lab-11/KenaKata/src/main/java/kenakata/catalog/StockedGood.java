package kenakata.catalog;

import kenakata.settlement.Seller;

public class StockedGood extends CatalogueItem implements weighable,Insurable,Returnable{
    private static final double comission_rate=0.08;
    private static final double vat=0.075;
    private static final int window_day=7;
    private final int weightgrams;

    public StockedGood(String sku, String title, long unitprice, int livestock, Seller seller ,int weightgrams) {
        super(sku, title, unitprice, livestock, seller);
        if(weightgrams<=0){
            throw new IllegalArgumentException("It is not valid");
        }
         this.weightgrams=weightgrams;
    }

    @Override
    public long unitVat() {
        return (long)Math.ceil(unitCharge()*vat);
    }

    @Override
    public long commissionOn(long amount) {
        return (long)Math.ceil(amount*comission_rate);
    }


    @Override
    public long insuranceFee(int quantity) {
        return 0;
    }

    @Override
    public int returnWindowDays() {
        return window_day;
    }

    @Override
    public int unitWeightGrams() {
        return weightgrams;
    }
}
