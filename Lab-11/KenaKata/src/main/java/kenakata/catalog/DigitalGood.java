package kenakata.catalog;

public class DigitalGood extends StockedGood {
    public DigitalGood(String s, String s1, int i, int i1, Seller seller) {
        super();
    }

    @Override
    public long unitCharge() {
        return 300L;
    }

    @Override
    public long unitVat() {
        return 15L;
    }

    public int commissionOn(int i) {
        return 60;
    }
}
