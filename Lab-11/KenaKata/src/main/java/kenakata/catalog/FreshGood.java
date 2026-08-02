package kenakata.catalog;

public class FreshGood extends CatalogItem{
    private final int weight;

    public FreshGood(String sku, String title, long price, int stock, Seller seller, int weight) {
        super(sku, title, price, stock, seller);
        if(weight<=0) throw new IllegalArgumentException();
        this.weight=weight;
    }

    @Override
    public long unitVat() {
        return 0;
    }

    @Override
    public long comissionOn(long val) {
        return (long) Math.ceil(val * 0.05);
    }

    @Override
    public Integer weightGrams() {
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
    public Integer returnWindowDays() {
        return 100000;
    }
}
