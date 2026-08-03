package kenakata.catalog;

public class WarrentyPlan implements Chargeable {
    private final CatalogItem covered;

    public WarrentyPlan(CatalogItem covered) {
        this.covered = covered;
    }

    @Override
    public long unitVat() {
        return 0;
    }

    @Override
    public long unitCharge() {
        return 0;
    }

    @Override
    public String label() {
        return "";
    }
}
