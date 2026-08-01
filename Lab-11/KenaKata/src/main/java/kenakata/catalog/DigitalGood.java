package kenakata.catalog;

public final class DigitalGood extends CatalogItem {

    private static final double VAT_PERCENT = 5;
    private static final double COMMISSION_PERCENT = 20;

    public DigitalGood(String sku, String title, long unitPrice, int stock, Seller seller) {
        super(sku, title, unitPrice, stock, seller);
    }

    @Override
    public long unitVat() {
        return MoneyMath.ceilPercentage(unitCharge(), VAT_PERCENT);
    }

    @Override
    public long commissionOn(long value) {
        return MoneyMath.ceilPercentage(value, COMMISSION_PERCENT);
    }
}
