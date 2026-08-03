package kenakata.catalog;

public final class ExpressHandling implements Chargeable {
    @Override
    public long unitCharge() {
        return 120;
    }

    @Override
    public long unitVat() {
        return MoneyMath.ceilRate(unitCharge(), 75, 1000);
    }

    @Override
    public String label() {
        return "express handling.....";
    }
}
