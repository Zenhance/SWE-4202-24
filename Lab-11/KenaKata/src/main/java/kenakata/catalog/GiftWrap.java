package kenakata.catalog;

public class GiftWrap implements Chargeable {

    private static final long CHARGE = 50;
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
        return "Gift wrapping";
    }
}