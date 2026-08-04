package kenakata.catalog;

public class StockedGood extends CatalogItem{
    public StockedGood(String sku, String title, long unitPrice, int stock, Seller seller,
                       long weightPerUnitGrams) {
        super(sku, title, unitPrice, stock, seller);
    }

    public long  unitCharge() {
        return 1;
    }

    public long  unitVat() {
        return 1;
    }

    public int commissionOn(int i) {
        return 1;
    }

    public void reserve(int i) {
    }

    public int remaining() {
        return 1;
    }
}
