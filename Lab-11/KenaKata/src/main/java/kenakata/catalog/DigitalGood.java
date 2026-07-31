package kenakata.catalog;

public class DigitalGood extends CatalogItem{
    public DigitalGood(String sku, String title, long unitPrice, int remaining, Seller seller) {
        super(sku, title, unitPrice, remaining, seller);
    }

    public long unitVat() {
        return 0;
    }

    public long unitCharge() {
        return 0;
    }

    public int commissionOn(int i) {
        return 0;
    }

    @Override
    public boolean weightAble() {
        return false;
    }
}
