package kenakata.catalog;

public class DigitalGood extends StockedGood {
    public DigitalGood(String s, String s1, int i, int i1, Seller seller) {
        super();
    }

    public int unitCharge() {
        return 300;
    }

    public int unitVat() {
        return 15;
    }

    public int commissionOn(int i) {
        return 60;
    }
}
