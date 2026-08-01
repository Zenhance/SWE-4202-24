package kenakata.catalog;

public final class StockedGood extends CatalogItem implements Weighable, Insurable, Returnable, Discountable {

    private static final double VAT_PERCENT = 7.5;
    private static final double COMMISSION_PERCENT = 8;
    private static final int RETURN_WINDOW_DAYS = 7;
    private final long unitWeightGrams;

    public StockedGood(String sku, String title, long unitPrice, int stock, Seller seller, long unitWeightGrams) {
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
    public long unitVat() {
        return MoneyMath.ceilPercentage(unitCharge(), VAT_PERCENT);
    }

    @Override
    public long commissionOn(long value) {
        return MoneyMath.ceilPercentage(value, COMMISSION_PERCENT);
    }

    @Override
    public int returnWindowDays() {
        return RETURN_WINDOW_DAYS;
    }
}