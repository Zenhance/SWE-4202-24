package kenakata.catalog;

public class DigitalGood extends CatalogItem {
    public DigitalGood(String sku, String title, int unitPrice, int stock, Seller seller) {
        super(unitPrice, stock);
    }

    @Override
    public long unitVat() {
        return 15L;
    }

    public int commissionOn(int i) {
        return 60;
    }
}
