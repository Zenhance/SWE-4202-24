package kenakata.catalog;

public class GiftWrap implements Chargeable {
    @Override
    public String label() {
        return "GiftWrap";
    }
    @Override
    public long unitCharge() {
        return 50;
    }
    @Override
    public long unitVat() {
        return (long)Math.ceil((double)unitCharge()*0.075);
    }
}
