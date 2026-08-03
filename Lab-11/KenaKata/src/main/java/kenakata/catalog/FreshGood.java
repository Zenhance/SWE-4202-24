package kenakata.catalog;

public class FreshGood extends StockedGood {
    public FreshGood(String s, String hilsa, int i, int i1, Seller seller, int i2) {
        super();
    }

    public long unitVat() {
        return 0;
    }

    public int commissionOn(int i) {
        return 80;
    }
}
