package kenakata.catalog;


public final class WarrantyPlan implements Chargeable, Labeled {

    private static final double CHARGE_RATE = 10.0/100.0;
    private static final double VAT_RATE = 15.0/100.0;

    private final CatalogItem covered;

    public WarrantyPlan(CatalogItem covered) {
        if (covered == null) {
            throw new IllegalArgumentException("A warranty must cover an item");
        }
        this.covered = covered;
    }

    @Override
    public long unitCharge() {
        return (long) Math.ceil(covered.unitCharge()*CHARGE_RATE);
    }

    @Override
    public long unitVat() {
        return (long) Math.ceil(unitCharge()*VAT_RATE);
    }



    @Override
    public String label() {
        return "Warranty for " + covered.title();
    }
}
