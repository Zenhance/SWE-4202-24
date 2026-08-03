package kenakata.catalog;

public final class StockedGood extends CatalogItem
        implements Weighable, Insurable, Returnable, Discountable {

    private final long unitWeightGrams;

    public StockedGood(
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
        // 7.5% VAT, rounded upward
        return (unitCharge() * 75 + 999) / 1000;
    }

    @Override
    public long commissionOn(long lineValue) {
        if (lineValue < 0) {
            throw new IllegalArgumentException(
                    "Line value cannot be negative"
            );
        }
        return (lineValue * 8 + 99) / 100;
    }

    @Override
    public long unitWeightGrams() {
        return unitWeightGrams;
    }

    @Override
    public long insurableValue(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be positive"
            );
        }

        return unitCharge() * quantity;
    }

    @Override
    public int returnWindowDays() {
        return 7;
    }
}