package kenakata.catalog;

public class FreshGood extends CatalogItem implements Chargeable {
    public FreshGood(String s, String hilsa, int i, int i1, Seller seller, int i2) {
        super(s, hilsa, i, i1, seller);
    }

    public int unitVat() {
        return 0;
    }

    public int commissionOn(int i) {
        return 0;
    }
}
