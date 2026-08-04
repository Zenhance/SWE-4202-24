package kenakata.catalog;

import kenakata.settlement.Seller;
import kenakata.money.Money;

public final class StockedGood extends CatalogItem implements Weighable,Insurable,Returnable{
    private static final long VAT_PERMILLE=75;
    private static final long COMMISSION_PERMILLE= 80;
    private static final int RETURN_WINDOW_DAYS= 7;

    private long unitWeightGrams ;

    public StockedGood(String sku, String title, long unitPrice, int stock, Seller seller){
        super(sku,title,unitPrice,stock,seller);
        if(unitWeightGrams<=0){
            throw new IllegalArgumentException("unitWeightGrams must be positive");
        }
        this.unitWeightGrams=unitWeightGrams;
    }

    public StockedGood(String s, String item, int unitPrice, int stock, Seller seller, int unitWeightGrams) {
        super(s,item,unitPrice,stock,seller);
    }


    public long unitvat(){
    return Money.ceilPerMl(unitPrice(),VAT_PERMILLE);
    }
    @Override
    public long commissionOn(long lineValue) {
        return Money.ceilPerMl(lineValue, COMMISSION_PERMILLE);
    }

    @Override
    public int remaining() {
        return 0;
    }

    @Override
    public String sku() {
        return "";
    }

    public long unitWeightGrams() {
        return unitWeightGrams;
    }
    @Override
    public int returnWindowDays() {
        return RETURN_WINDOW_DAYS;
    }

    @Override
    public long unitVat() {
        return 0;
    }

    @Override
    public long unitPrice() {
        return 0;
    }

    @Override
    public long unitCharge() {
        return 0;
    }


    public Seller seller() {
        return null;
    }

    @Override
    public long unitWeight() {
        return 0;
    }
}
