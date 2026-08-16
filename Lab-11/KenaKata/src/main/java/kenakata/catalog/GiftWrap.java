package kenakata.catalog;

public class GiftWrap implements Chargeable{
    public long unitVat() {
        return (long) Math.ceil(50 * 0.075);
    }

    public long unitCharge() {
        return 50;
    }

    public String label() {
        return "Gift wrapping";
    }
}
