package kenakata.catalog;

public class GiftWrap implements Chargeable {
    @Override
    public long unitVat() {
        return (long) Math.ceil(50 * 0.075);
    }

    @Override
    public long unitCharge() {
        return 50;
    }

    @Override
    public String label() {
        return "Gift Wrapping";
    }
}
