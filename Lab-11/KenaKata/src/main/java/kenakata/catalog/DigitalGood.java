package kenakata.catalog;

public class DigitalGood extends CatalogItem implements Chargeable {
    public DigitalGood(String sku, String title, long unitPrice, int stock, Seller seller) {
        super(sku,  title, unitPrice, stock, seller);
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
