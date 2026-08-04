package kenakata.catalog;

public class DigitalGood extends CatalogItem{
    public DigitalGood(String sku, String title, long unitPrice, int stock, Seller seller) {
        super(sku, title, unitPrice, stock, seller);
    }

    public long unitCharge() {
        return 1;
    }

    public long unitVat() {
        return 1;
    }

    public int commissionOn(int i) {
        return 1;
    }
}
