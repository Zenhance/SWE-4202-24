package kenakata.catalog;

import kenakata.util.Money;


public final class StockedGood extends CatalogItem implements Weighable, Insurable, Returnable {

    private static final long VAT_PERMILLE = 75;          // 7.5%
    private static final long COMMISSION_PERMILLE = 80;   // 8%
    private static final int RETURN_WINDOW_DAYS = 7;

    private final long unitWeightGrams;

    public StockedGood(String sku, String title, long unitPrice, int stock, Seller seller,
            long unitWeightGrams) {
        super(sku, title, unitPrice, stock, seller);
        if (unitWeightGrams <= 0) {
            throw new IllegalArgumentException("unitWeightGrams must be positive");
        }
        this.unitWeightGrams = unitWeightGrams;
    }

    @Override
    public long unitVat() {
        return Money.ceilPermille(unitPrice(), VAT_PERMILLE);
    }

    @Override
    public long commissionOn(long lineValue) {
        return Money.ceilPermille(lineValue, COMMISSION_PERMILLE);
    }

    @Override
    public long unitWeightGrams() {
        return unitWeightGrams;
    }

    @Override
    public int returnWindowDays() {
        return RETURN_WINDOW_DAYS;
    }
}
