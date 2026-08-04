package kenakata.catalog;

import kenakata.util.Money;

/**
 * An extended warranty plan protecting a single item on the order. Its charge is derived from
 * the unit price of the item it covers, rather than being a flat figure of its own.
 */
public final class WarrantyPlan implements Chargeable {

    private static final long CHARGE_PERMILLE = 100; // 10% of covered item's unit price
    private static final long VAT_PERMILLE = 150;    // 15%

    private final CatalogItem coveredItem;

    public WarrantyPlan(CatalogItem coveredItem) {
        if (coveredItem == null) {
            throw new IllegalArgumentException("coveredItem must not be null");
        }
        this.coveredItem = coveredItem;
    }

    @Override
    public long unitCharge() {
        return Money.ceilPermille(coveredItem.unitPrice(), CHARGE_PERMILLE);
    }

    @Override
    public long unitVat() {
        return Money.ceilPermille(unitCharge(), VAT_PERMILLE);
    }

    @Override
    public String label() {
        return "Extended warranty for " + coveredItem.title();
    }
}
