package kenakata.catalog;

public class FreshGood extends CatalogItem{
    private final double weight;
    public FreshGood(String sku, String title, long unitPrice, int remaining, Seller seller, double weight) {
        super(sku, title, unitPrice, remaining, seller);
        this.weight = weight;
    }

    public long unitVat() {
        return 0;
    }

    public int commissionOn(int i) {
        return 0;
    }

    @Override
    public boolean weightAble() {
        return true;
    }

    @Override
    public double weight() {
        return weight;
    }
}
