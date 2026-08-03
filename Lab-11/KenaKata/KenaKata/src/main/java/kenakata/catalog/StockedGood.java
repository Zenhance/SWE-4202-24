package kenakata.catalog;

public final class StockedGood extends CatalogItem implements Weighable, Insurable, Returnable {
    private final int weightGrams;

    public StockedGood(String sku, String title, long unitPrice, int stock,
                       Seller seller, int weightGrams) {
        super(sku, title, unitPrice, stock, seller);
        if (weightGrams <= 0) {
            throw new IllegalArgumentException("Weight invalid");
        }
        this.weightGrams = weightGrams;
    }

    @Override
    public long unitVat() {
        return MoneyMath.ceilRate(unitCharge(), 75, 1000);
    }

    @Override
    public long commissionOn(long lineValue) {
        return MoneyMath.ceilRate(lineValue, 8, 100);
    }

    @Override
    public int unitWeightGrams() {
        return weightGrams;
    }

    public int weightGrams() {
        return weightGrams;
    }

    @Override
    public long insurableValue() {
        return unitCharge();
    }

    @Override
    public int returnWindowDays() {
        return 7;
    }
}
