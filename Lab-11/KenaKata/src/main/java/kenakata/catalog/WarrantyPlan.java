package kenakata.catalog;

public class WarrantyPlan implements Chargeable {
    private final CatalogItem covered;

    public WarrantyPlan(CatalogItem covered) {
        if(covered == null) {throw new IllegalArgumentException("Covered item can't be null");}
        this.covered = covered;
    }

    @Override
    public long unitVat() {
        return (long) Math.ceil(unitCharge() * 0.15);
    }

    @Override
    public long unitCharge() {
        return (long) Math.ceil(covered.unitCharge() * 0.10);
    }

    @Override
    public String label() {
        return "Warranty for " + covered.label();
    }

    public CatalogItem covered() {
        return covered;
    }
}
