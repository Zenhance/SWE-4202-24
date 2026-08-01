package kenakata.catalog;

public final class FreshGood extends CatalogItem implements Returnable, Weighable, Insurable, ColdChain {
    private static final double COMMISSION_PERCENT = 5;
    private static final long COLD_CHAIN_SURCHARGE = 50;
    private static final int RETURN_WINDOW_DAYS = 2;
    private final long unitWeightGrams;
    public FreshGood(String sku, String title, long unitPrice, int stock, Seller seller, long unitWeightGrams) {
        super(sku, title, unitPrice, stock, seller);
        if (unitWeightGrams <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.unitWeightGrams = unitWeightGrams;
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
    public long unitVat() {
        return 0;
    }

    @Override
    public long commissionOn(long value) {
        return MoneyMath.ceilPercentage(value, COMMISSION_PERCENT);
    }

    @Override
    public int returnWindowDays() {
        return RETURN_WINDOW_DAYS;
    }}