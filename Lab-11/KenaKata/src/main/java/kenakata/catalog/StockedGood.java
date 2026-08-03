package kenakata.catalog;

public class StockedGood extends CatalogItem{

    private final int weight;
    public StockedGood(String sku, String title, long unitPrice, int stock, Seller seller, int weight) {
        super(sku, title, unitPrice, stock, seller);
        this.weight = weight;
    }

    @Override
    public double unitCharge() {
        return 0;
    }

    @Override
    public int unitVat() {
        return (int) Math.ceil(getUnitPrice() * 0.075);
    }

    @Override
    public long commissionOn(long lineValue) {
        return 0;
    }

    @Override
    public int commissionOn(int total) {
        return (int) Math.ceil(total * 0.08);
    }
}
