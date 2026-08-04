package kenakata.catalog;

public class StockedGood extends CatalogItem {
    private final int weight;

    public StockedGood(String sku, String title, long unitPrice, int stock, Seller seller, int weight) {
        super(sku, title, unitPrice, stock, seller);
        if (weight <= 0) throw new IllegalArgumentException("Weight must be positive");
        this.weight = weight;
    }

    @Override public long unitVat() { return (long) Math.ceil(unitCharge() * 0.075); }
    @Override public long commissionOn(long totalCharge) { return (long) Math.ceil(totalCharge * 0.08); }
    @Override public boolean isWeighable() { return true; }
    @Override public int weight() { return weight; }
    @Override public boolean isDiscountable() { return true; }
    @Override public boolean isInsurable() { return true; }
    @Override public boolean isReturnable() { return true; }
    @Override public int returnWindowDays() { return 7; }
}