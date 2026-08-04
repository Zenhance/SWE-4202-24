package kenakata.catalog;

public class FreshGood extends StockedGood {
    public FreshGood(String s, String hilsa, int i, int i1, Seller seller, int i2) {
        super();
    }

    @Override
    public long unitVat() {
        return 0L;
    }

    public int commissionOn(int i) {
        return 80;
    }
}
