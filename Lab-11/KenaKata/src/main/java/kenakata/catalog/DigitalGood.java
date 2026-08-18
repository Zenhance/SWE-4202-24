package kenakata.catalog;

public class DigitalGood extends CatalogItem {

    private static final long VAT_BASIS_POINTS = 50;
    private static final long COMMISSION_BASIS_POINTS = 200;

    public DigitalGood(String sku, String title, long unitPrice, long stock, Seller seller) {
        super(sku, title, unitPrice, stock, seller);
    }

    @Override
    public long unitVat() {
        return Money.ceilPercent(unitPrice(), VAT_BASIS_POINTS);
    }

    @Override
    public long commissionOn(long lineValue) {
        return Money.ceilPercent(lineValue, COMMISSION_BASIS_POINTS);
    }
}