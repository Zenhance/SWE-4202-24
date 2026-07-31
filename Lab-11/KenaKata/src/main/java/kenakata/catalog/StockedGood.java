package kenakata.catalog;

public class StockedGood extends CatalogItem{
    private final double weight;

    public StockedGood(String sku, String title, long unitPrice, int remaining, Seller seller, double weight) {
        super(sku, title, unitPrice, remaining, seller);
        this.weight = weight;
    }

    public long unitCharge() {
        return 0;
    }

    public long unitVat() {
        return 0;
    }

    public int commissionOn(int i) {
    }

    @Override
    public boolean weightAble() {
        return true;
    }

    public void reserve(int i) {
    }

    public int remaining() {
    }

    @Override
    public double weight() {
        return weight;
    }
}
