package kenakata.catalog;

public class GiftWrap implements Item {
    @Override
    public long unitCharge() { return 50; }

    @Override
    public long unitVat() {
        return (long) 0;
    }

    @Override
    public String label() { return "Gift wrapping"; }
}
