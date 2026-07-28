package kenakata.catalog;

public class FreshGood extends CatalogItem {

    private final int weight;

    public FreshGood(String sku, String title, long price, int stock, Seller seller, int weight) {
        super(sku, title, price, stock, seller);
        if(weight <= 0) throw new IllegalArgumentException();
        this.weight = weight;
    }

    @Override
    public long unitVat() {
        return 0;
    }

    @Override
    public long commissionOn(long amount) {
        return ceilPercent(amount, 5);
    }

    @Override
    public int weightGrams() {
        return weight;
    }

    @Override
    public boolean isColdChain() {
        return true;
    }

    @Override
    public boolean isInsurable() {
        return true;
    }

    @Override
    public boolean isReturnable() {
        return true;
    }

    @Override
    public int returnWindow() {
        return 2;
    }

    private long ceilPercent(long value, double percent) {
        return (long)Math.ceil(value * percent / 100.0);
    }
}