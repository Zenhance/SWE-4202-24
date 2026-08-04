package kenakata.catalog;

import kenakata.util.Money;

public final class FreshGood extends CatalogItem
        implements Weighable, ColdChainRequired, Insurable, Returnable {

    private static final long COMMISSION_PERMILLE = 50;   // 5%
    private static final long COLD_CHAIN_SURCHARGE = 50;
    private static final int RETURN_WINDOW_DAYS = 2;

    private final long unitWeightGrams;

    public FreshGood(String sku, String title, long unitPrice, int stock, Seller seller,
            long unitWeightGrams) {
        super(sku, title, unitPrice, stock, seller);
        if (unitWeightGrams <= 0) {
            throw new IllegalArgumentException("unitWeightGrams must be positive");
        }
        this.unitWeightGrams = unitWeightGrams;
    }

    @Override
    public long unitVat() {
        return 0; // VAT-exempt
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
    public long coldChainSurcharge() {
        return COLD_CHAIN_SURCHARGE;
    }

    @Override
    public int returnWindowDays() {
        return RETURN_WINDOW_DAYS;
    }
}
