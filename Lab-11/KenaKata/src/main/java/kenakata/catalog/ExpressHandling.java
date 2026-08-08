package kenakata.catalog;

public class ExpressHandling implements Chargeable{
    public long unitCharge() {
        return 120;
    }

    @Override
    public long unitVat() {
        return (long) Math.ceil(unitCharge() * 0.075);
    }
}
