package kenakata.catalog;

public final class FreshGood extends CatalogItem
        implements Weighable, ColdChain, Insurable, Returnable {

    private static final double COMISSION = 5.0;
    private static final long COLD_CHAIN_SURCHARGE = 50;
    private static final int RETURN_WINDOW_DAYS = 2;

    private final long unitWeightGrams;

    public FreshGood(String sku, String title, long unitPrice, int stock, Seller seller,
                     long unitWeightGrams) {
        super(sku, title, unitPrice, seller, stock);
        if (unitWeightGrams <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.unitWeightGrams = unitWeightGrams;
    }




    @Override
    public long commissionOn(long lineValue) {
        return (long) Math.ceil(lineValue*COMISSION);
    }


    public long unitWeightGrams() {
        return unitWeightGrams;
    }


    public long coldChainSurcharge() {
        return COLD_CHAIN_SURCHARGE;
    }


    public int returnWindowDays() {
        return RETURN_WINDOW_DAYS;
    }

    @Override
    public long vatCharge() {
        return 0;
    }
}
