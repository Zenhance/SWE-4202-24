package kenakata.catalog;

public class FreshGood extends CatalogItem implements Weighable, RequiresColdChain, Insurable, Returnable {

    private static final long COMMISSION_BASIS_POINTS = 50;
    private static final int RETURN_WINDOW_DAYS = 2;

    private final long weightGrams;

    public FreshGood(String sku, String title, long unitPrice, long stock, Seller seller, long weightGrams) {
        super(sku, title, unitPrice, stock, seller);
        if (weightGrams <= 0) {
            throw new IllegalArgumentException("weightGrams must be positive");
        }
        this.weightGrams = weightGrams;
    }

    @Override
    public long unitVat() {
        return 0;
    }

    @Override
    public long commissionOn(long lineValue) {
        return Money.ceilPercent(lineValue, COMMISSION_BASIS_POINTS);
    }

    @Override
    public long weightGrams() {
        return weightGrams;
    }

    @Override
    public int returnWindowDays() {
        return RETURN_WINDOW_DAYS;
    }
}