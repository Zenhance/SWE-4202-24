package kenakata.catalog;

public class GiftWrap implements Chargeable {
    public long unitCharge() {
        return 1;
    }

    public long unitVat() {
        return 1;
    }

    public String label() {
        return "Ab";
    }
}
