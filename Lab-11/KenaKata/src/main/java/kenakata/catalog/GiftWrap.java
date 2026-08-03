package kenakata.catalog;

public class GiftWrap extends AddOnLines {
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
        return (long)Math.ceil((double)unitCharge()*0.75);
    }
}
