package kenakata.catalog;

public class ExpressHandling implements Chargeable {

    private static final long CHARGE = 120;
    private static final long VAT_BASIS_POINTS = 75;

    @Override
    public long unitCharge() {
        return CHARGE;
    }

    @Override
    public long unitVat() {
        return Money.ceilPercent(CHARGE, VAT_BASIS_POINTS);
    }

    @Override
    public String label() {
        return "Express handling";
    }
}