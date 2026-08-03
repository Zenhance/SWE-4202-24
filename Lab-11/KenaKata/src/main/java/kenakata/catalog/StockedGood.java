package kenakata.catalog;


public class StockedGood extends CatalogItem implements Weighable, Insurable, Returnable {
    private static final double VAT=0.075;
    private static final double COMISSION=8.0/100.0;
    private final long unitWeightGrams;
    private static final int RETURN_WINDOW_DAYS = 7;

    public StockedGood(String SKU, String title, double UnitPrice, int Stock, Seller seller, long unitWeightGrams) {
        super(SKU, title, UnitPrice, Stock, seller);
        if (unitWeightGrams <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.unitWeightGrams = unitWeightGrams;
    }



    @Override
    public long unitVat() {
        return (long) Math.ceil(unitCharge()*VAT);
    }
    public long commissionOn(long lineValue) {
        return (long) Math.ceil(lineValue*COMISSION);
    }


    public long unitWeightGrams() {
        return unitWeightGrams;
    }


    public int returnWindowDays() {
        return RETURN_WINDOW_DAYS;
    }
}
