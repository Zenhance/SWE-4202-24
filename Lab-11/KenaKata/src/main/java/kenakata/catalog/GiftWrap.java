package kenakata.catalog;

public class GiftWrap implements Chargeable {
    public long unitVat() {
        return 4;
    }

    public long unitCharge() {
        return 50;
    }

    public String label() {
        return "Gift wrapping";
    }
}
