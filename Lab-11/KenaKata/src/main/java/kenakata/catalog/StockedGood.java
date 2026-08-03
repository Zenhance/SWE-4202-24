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

    @Override
    public long commissionOn(long i) {
        return (long) (i*.08);
    }

    @Override
    public int returnDays() {
        return 7;
    }

    @Override
    public String label() {
        return "";
    }

    @Override
    public boolean insurable() {
        return true;
    }

    @Override
    public boolean returnable() {
        return true;
    }

    @Override
    public boolean isWeighable() {
        return true;
    }

    @Override
    public double weight() {
        return weight;
    }
}
