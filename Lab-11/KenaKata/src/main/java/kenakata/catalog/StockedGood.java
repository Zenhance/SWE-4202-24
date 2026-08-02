package kenakata.catalog;

public class StockedGood extends CatalogItem{
    public StockedGood(String sku, String title, double unitPrice, int stock, Seller seller) {
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
