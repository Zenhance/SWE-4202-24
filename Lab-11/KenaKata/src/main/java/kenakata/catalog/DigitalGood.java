package kenakata.catalog;

public class DigitalGood extends CatalogItem {

    public DigitalGood(String sku, String title, long price, int stock, Seller seller) {
        super(sku, title, price, stock, seller);
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
