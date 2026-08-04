package kenakata.catalog;

public class FreshGood extends CatalogItem {
    public FreshGood(String sku, String title, long unitPrice, int stock, Seller seller,
                     long weightPerUnitGrams) {
        super(sku, title, unitPrice, stock, seller);
    }

    public long unitVat() {
        return 1;
    }

    public int commissionOn(int i) {
        return 1;
    }
}
