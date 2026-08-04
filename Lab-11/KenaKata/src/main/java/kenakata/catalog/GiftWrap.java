package kenakata.catalog;

public class GiftWrap implements Chargeable {
    private static final double vat=0.075;
    private static final int wrapping_charge=50;

    @Override
    public long unitVat() {
        return (long)Math.ceil(unitCharge()*vat);
    }

    @Override
    public String label() {
        return "Gift wrapping";
    }

    @Override
    public long unitCharge() {
        return wrapping_charge;
    }
}
