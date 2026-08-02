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
        return (int) Math.ceil(getUnitPrice() * 0.075);
    }

    @Override
    public int commissionOn(int total) {
        return (int) Math.ceil(total * 0.08);
    }
}
