package kenakata.catalog;

public class WarrentyPlan implements Chargeable {
    private final CatalogItem covered;

    public WarrentyPlan(CatalogItem covered) {
        if(covered == null) {throw new IllegalArgumentException("Covered item can't be null");}
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
