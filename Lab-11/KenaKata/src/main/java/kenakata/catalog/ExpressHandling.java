package kenakata.catalog;

import kenakata.catalog.Chargeable;
import kenakata.catalog.MoneyMath;

public final class ExpressHandling implements Chargeable {

    private static final long CHARGE = 120;
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
        return "Express handling";
    }
}