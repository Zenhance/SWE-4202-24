package kenakata.catalog;

public final class FreshGood extends CatalogItem
        implements Weighable, ColdChain, Insurable, Returnable {
    private final int weightGrams;

    public FreshGood(String sku, String title, long unitPrice, int stock,
                     Seller seller, int weightGrams) {
        super(sku, title, unitPrice, stock, seller);
        if (weightGrams <= 0) {
            throw new IllegalArgumentException("weight should be positive");
        }
        this.weightGrams = weightGrams;
    }

    @Override
    public long unitVat() {
        return 0;
    }

    @Override
    public long commissionOn(long lineValue) {
        return MoneyMath.ceilRate(lineValue, 5, 100);
    }

    @Override
    public int unitWeightGrams() {
        return weightGrams;
    }

    public int weightGrams() {
        return weightGrams;
    }

    @Override
    public long coldChainSurcharge() {
        return 50;
    }

    @Override
    public long insurableValue() {
        return unitCharge();
    }

    @Override
    public int returnWindowDays() {
        return 2;
    }
}
