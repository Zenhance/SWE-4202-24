package kenakata.catalog;
public final class FreshGood extends CatalogItem
        implements Weighable, ColdChain, Insurable, Returnable {

    private final long unitWeightGrams;

    public FreshGood(
            String sku,
            String title,
            long unitPrice,
            int stock,
            Seller seller,
            long unitWeightGrams
    ) {
        super(sku, title, unitPrice, stock, seller);

        if (unitWeightGrams <= 0) {
            throw new IllegalArgumentException(
                    "Weight must be positive"
            );
        }

        this.unitWeightGrams = unitWeightGrams;
    }

    @Override
    public long unitVat() {
        return 0;
    }

    @Override
    public long commissionOn(long lineValue) {
        requireLineValue(lineValue);

        return Money.ceilFraction(
                lineValue,
                5,
                100
        );
    }

    @Override
    public long unitWeightGrams() {
        return unitWeightGrams;
    }

    @Override
    public long coldChainSurcharge() {
        return 50;
    }

    @Override
    public long insurableValue(int quantity) {
        requirePositiveQuantity(quantity);

        return Math.multiplyExact(
                unitCharge(),
                quantity
        );
    }

    @Override
    public int returnWindowDays() {
        return 2;
    }
}