package kenakata.catalog;

public class FreshGood extends CatalogItem{
    public FreshGood(String sku, String title, double unitPrice, int stock, Seller seller) {
        super(sku, title, unitPrice, stock, seller);
    }

    @Override
    public int unitCharge() {
        return 0;
    }

    @Override
    public int unitVat() {
        return 0;
    }

    @Override
    public int commissionOn(int total) {
        return 0;
    }
}
