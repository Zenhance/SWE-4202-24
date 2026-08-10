package kenakata.catalog;

public class ExpressHandling implements Chargeable {
    public long unitCharge() {
        return 120;
    }
    public long unitVat() {
        return 9;
    }
    public long commissionOn(long value) {
        return 0;
    }
    public String label() {
        return "Express handling";
    }
}