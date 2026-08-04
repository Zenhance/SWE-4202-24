package kenakata.catalog;

public class DigitalGood extends CatalogItem implements Chargeable {
    public DigitalGood(String s, String s1, int i, int i1, Seller seller) {
        super(s, s1, i, i1, seller);
    }

    public int unitCharge() {
        return 0;
    }

    public int unitVat() {
        return 0;
    }

    public int commissionOn(int i) {
        return 0;
    }
}
