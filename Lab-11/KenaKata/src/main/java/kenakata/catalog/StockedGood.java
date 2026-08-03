package kenakata.catalog;

public class StockedGood extends CatalogItem {

    private final int weight;

    public StockedGood(String sku, String title, long unitPrice, int stock, Seller seller, int weight) {
        super(sku, title, unitPrice, stock, seller);
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.weight = weight;
    }

    public int weight() {
        return weight;
    }

    public int returnWindow() {
        return 7;
    }

    @Override
    public long unitVat() {
        return (long) Math.ceil(unitCharge() * 0.075);
    }

    @Override
    public long commissionOn(long lineValue) {
        return (long) Math.ceil(lineValue * 0.08);
    }
}
