package kenakata.catalog;

public class GiftWrap implements Chargeable {
    @Override
    public long unitCharge() {
        return 50;
    }
    @Override
    public long unitVat() {
        return (unitCharge() * 75 + 99) / 100;
    }
    @Override
    public String label() {
        return "Gift wrapping";
    }
}