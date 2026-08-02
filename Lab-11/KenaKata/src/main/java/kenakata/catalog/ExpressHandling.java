package kenakata.catalog;

public class ExpressHandling implements Chargeable {
    @Override
    public long unitCharge() {
        return 120;
    }
    @Override
    public long unitVat() {
        return (unitCharge() * 75 + 999) / 1000;
    }
    @Override
    public String label() {
        return "Express handling";
    }
}