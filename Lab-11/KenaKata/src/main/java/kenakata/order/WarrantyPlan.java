package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
import kenakata.catalog.MoneyMath;

public final class WarrantyPlan implements Chargeable {

    private static final double CHARGE_PERCENT = 10;
    private static final double VAT_PERCENT = 15;

    private final CatalogItem coveredItem;

    public WarrantyPlan(CatalogItem coveredItem) {
        if (coveredItem == null) {
            throw new IllegalArgumentException("Covered item must not be null");
        }
        this.coveredItem = coveredItem;
    }

    @Override
    public long unitCharge() {
        return MoneyMath.ceilPercentage(coveredItem.unitCharge(), CHARGE_PERCENT);
    }

    @Override
    public long unitVat() {
        return MoneyMath.ceilPercentage(unitCharge(), VAT_PERCENT);
    }

    @Override
    public String label() {
        return "Warranty for " + coveredItem.title();
    }
}