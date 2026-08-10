package kenakata.catalog;

public class FreshGood extends CatalogItem {
    public FreshGood(String sku, String title, int unitPrice, int stock, Seller seller, int weightGrams) {
        super(unitPrice, stock);
    }

    @Override
    public long unitVat() {
        return 0L;
    }

    public int commissionOn(int i) {
        return 80;
    }
}
