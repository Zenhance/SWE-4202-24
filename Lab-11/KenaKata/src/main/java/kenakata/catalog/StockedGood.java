package kenakata.catalog;

public class StockedGood extends CatalogItem implements Charge{
    protected int weight;

    public StockedGood(String sku, String title, long unitPrice, int stock, Seller seller, int weight){
        super(sku, title, unitPrice, stock, seller);
        this.weight = weight;
    }

    @Override
    public long commissionOn(int amount) {
        return (long) (amount * 0.08);
    }

    @Override
    public long unitCharge() {
        return 0;
    }

    @Override
    public long unitVat() {
        return (long) (weight * 0.075);
    }
}
