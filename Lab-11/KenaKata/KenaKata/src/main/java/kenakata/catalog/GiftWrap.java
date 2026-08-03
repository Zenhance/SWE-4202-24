package kenakata.catalog;

public final class GiftWrap implements Chargeable {
    @Override
    public long unitCharge() {
        return 50;
    }

    @Override
    public long unitVat() {
        return MoneyMath.ceilRate(unitCharge(), 75, 1000);
    }

    @Override
    public String label() {
        return "Gift wrapping......";
    }
}
