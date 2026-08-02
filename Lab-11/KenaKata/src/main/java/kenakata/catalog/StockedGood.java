package kenakata.catalog;

public class StockedGood extends CatalogItem {
    private final int weight;

    public StockedGood(String sku, String title, long unitPrice, int initialStock, Seller seller, int weight) {
        super(sku, title, unitPrice, initialStock, seller);
        this.weight = weight;
    }

    public long unitVat() {
        return (long) Math.ceil(unitPrice() * 0.075);
    }

    public long comissionOn(long val) {
        return (long) Math.ceil(val * 0.08);
    }

    public Integer weightGrams() {
        return weight;
    }
    public boolean isInsurable() {
        return true;
    }
    public Integer returnWindowDays() {
        return 7;
    }
}
