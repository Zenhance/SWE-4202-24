package kenakata.catalog;

import kenakata.util.Money;

/**
 * A product delivered by download. It never ships (no weight), carries a lower VAT rate, cannot
 * be returned or insured, and earns the platform its highest commission.
 */
public final class DigitalGood extends CatalogItem {

    private static final long VAT_PERMILLE = 50;          // 5%
    private static final long COMMISSION_PERMILLE = 200;  // 20%

    public DigitalGood(String sku, String title, long unitPrice, int stock, Seller seller) {
        super(sku, title, unitPrice, stock, seller);
    }

    @Override
    public long unitVat() {
        return Money.ceilPermille(unitPrice(), VAT_PERMILLE);
    }

    @Override
    public long commissionOn(long lineValue) {
        return Money.ceilPermille(lineValue, COMMISSION_PERMILLE);
    }
}
