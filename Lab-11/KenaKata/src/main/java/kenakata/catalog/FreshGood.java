package kenakata.catalog;

public class FreshGood extends CatalogItem implements Chargeable{

    protected int weight;

    public FreshGood(String sku, String title, long unitPrice, int stock, Seller seller, int weight){
        super(sku, title, unitPrice, stock, seller);
        this.weight = weight;
    }
    @Override
    public long unitCharge() {
        return unitPrice;
    }
    @Override
    public long unitVat() {
        return 0;
    }
    @Override
    public long commissionOn(int amount) {
        return (long) (amount * 0.05);
    }
}
