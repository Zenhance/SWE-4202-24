package kenakata.catalog;

public class GiftWrap extends AddOn {
    @Override
    public long unitCharge() {
        return 50;
    }

    @Override
    public long unitVat() {
        return (50*75 + 999)/1000;
    }

    @Override
    public String label() {
        return "Gift wrapping";
    }
}