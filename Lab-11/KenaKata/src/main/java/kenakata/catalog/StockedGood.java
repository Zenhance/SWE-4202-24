package kenakata.catalog;

public class StockedGood extends CatalogItem {
    public StockedGood(String s, String tableLamp, int i, int i1, Seller s1, int i2) {
    }

    public StockedGood() {

    }

    public long unitCharge() {
        return 1200;
    }

    public long unitVat() {
        return 90;
    }

    public int commissionOn(int i) {
        return 192;
    }

    public void reserve(int i) {
    }

    public int remaining() {
        return 2;
    }
}
