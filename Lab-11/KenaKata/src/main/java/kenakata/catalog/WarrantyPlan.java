package kenakata.catalog;

public class WarrantyPlan implements Chargeable
{
    private static final long CHARGE_BASIS_POINTS = 100;
    private static final long VAT_BASIS_POINTS = 150;
    private final CatalogItem covered;
    public WarrantyPlan(CatalogItem covered) {
        if (covered == null) {
            throw new IllegalArgumentException("covered item must not be null");
        }
        this.covered = covered;
    }

    @Override
    public long unitCharge() {
        return Money.ceilPercent(covered.unitPrice(), CHARGE_BASIS_POINTS);
    }

    @Override
    public long unitVat() {
        return Money.ceilPercent(unitCharge(), VAT_BASIS_POINTS);
    }

    @Override
    public String label() {
        return "Warranty for " + covered.title();
    }
}