package kenakata.catalog;

import kenakata.util.Money;

public final class GiftWrap implements Chargeable {

    private static final long CHARGE = 50;
    private static final long VAT_PERMILLE = 75; // 7.5%

    @Override
    public long unitCharge() {
        return CHARGE;
    }

    @Override
    public long unitVat() {
        return Money.ceilPermille(CHARGE, VAT_PERMILLE);
    }

    @Override
    public String label() {
        return "Gift wrapping";
    }
}
