package kenakata.catalog;

public final class GiftWrap implements Chargeable {

    private static final long CHARGE = 50;
    private static final double VAT_PERCENT = 7.5;

    @Override
    public long unitCharge() {
        return CHARGE;
    }

    @Override
    public long unitVat() {
        return MoneyMath.ceilPercentage(CHARGE, VAT_PERCENT);
    }

    @Override
    public String label() {
        return "Gift wrapping";
    }
}
