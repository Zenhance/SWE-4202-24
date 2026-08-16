package kenakata.catalog;

public class ExpressHandling implements Chargeable {
    public long unitVat() {
        return (long) Math.ceil(120 * 0.075);
    }

    public long unitCharge() {
        return 120;
    }
}
