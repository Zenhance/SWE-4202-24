package kenakata.catalog;

public class GiftWrap implements Chargeable {
    public long unitCharge() {
        return 50;
    }

    public long unitVat() {
        return (long) Math.ceil(50*.075);
    }

    public String label() {
        return "Gift Wrapping";
    }
}
