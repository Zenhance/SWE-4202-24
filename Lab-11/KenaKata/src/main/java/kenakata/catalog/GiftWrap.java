package kenakata.catalog;

public class GiftWrap implements Chargeable {
    public long unitCharge() {
        return 50;
    }
    public long unitVat() {
        return 4;
    }
    public long commissionOn(long value) {
        return 0;
    }
    public String label() {
        return "Gift wrapping";
    }
}