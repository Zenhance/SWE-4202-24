package kenakata.catalog;

public final class WarrantyPlan implements Chargeable {
    private final CatalogItem coveredItem;

    public WarrantyPlan(CatalogItem coveredItem) {
        if (coveredItem == null) {
            throw new IllegalArgumentException("Covered required");
        }
        this.coveredItem = coveredItem;
    }

    public CatalogItem coveredItem() {
        return coveredItem;
    }

    @Override
    public long unitCharge() {
        return MoneyMath.ceilRate(coveredItem.unitCharge(), 10, 100);
    }

    @Override
    public long unitVat() {
        return MoneyMath.ceilRate(unitCharge(), 15, 100);
    }

    @Override
    public String label() {
        return "Warranty for " + coveredItem.title();
    }
}
