package kenakata.catalog;

import kenakata.util.Money;

/** Express handling: a larger flat charge, priced and taxed like any other line. */
public final class ExpressHandling implements Chargeable {

    private static final long CHARGE = 120;
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
        return "Express handling";
    }
}
