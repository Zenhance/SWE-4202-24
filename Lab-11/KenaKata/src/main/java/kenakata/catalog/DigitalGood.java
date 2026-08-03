package kenakata.catalog;

import kenakata.util.Money;

public final class DigitalGood extends CatalogItem {

    private static final int VAT_PERMILLE = 50;
    private static final int COMMISSION_PERMILLE = 200;

    public DigitalGood(String sku, String title, long unitPrice, int stock, Seller seller) {
        super(sku, title, unitPrice, stock, seller);
    }
    @Override
    public long unitVat() {
        return Money.ceilPercent(unitPrice(), VAT_PERMILLE);
    }

    @Override
    public long commissionOn(long lineValue) {
        return Money.ceilPercent(lineValue, COMMISSION_PERMILLE);
    }
}
