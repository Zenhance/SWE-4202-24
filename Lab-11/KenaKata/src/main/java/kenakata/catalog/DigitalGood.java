package kenakata.catalog;

public final class DigitalGood extends CatalogItem {

    public DigitalGood(
            String sku,
            String title,
            long unitPrice,
            int stock,
            Seller seller
    ) {
        super(sku, title, unitPrice, stock, seller);
    }

    @Override
    public long unitVat() {
        return Money.ceilFraction(
                unitCharge(),
                5,
                100
        );
    }

    @Override
    public long commissionOn(long lineValue) {
        requireLineValue(lineValue);

        return Money.ceilFraction(
                lineValue,
                20,
                100
        );
    }
}