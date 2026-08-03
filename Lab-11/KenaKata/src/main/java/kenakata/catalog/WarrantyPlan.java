package kenakata.catalog;

public final class WarrantyPlan implements Chargeable {

    private final CatalogItem covered;

    public WarrantyPlan(CatalogItem covered) {
        this.covered = covered;
    }

    @Override
    public long unitCharge() {
        return 0;
    }

    @Override
    public long unitVat() {
        return 0;
    }

    @Override
    public String label() {
        return "";

    }
}
