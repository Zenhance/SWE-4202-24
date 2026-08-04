package kenakata.catalog;

public class StockedGood extends CatalogItem implements Chargeable,Weightable,Returnable,Insurable{
    protected int weight;

    public StockedGood(String sku, String title, long unitPrice, int stock, Seller seller, int weight){
        super(sku, title, unitPrice, stock, seller);
        this.weight = weight;
    }

    @Override
    public long commissionOn(int amount) {
        return (long) Math.ceil(amount * 0.08);
    }

    @Override
    public long unitVat() {
        return (long) Math.ceil(unitPrice * 0.075);
    }

    @Override
    public int returnWindow() {
        return 7;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public long insure(long quantity) {
        return unitPrice*quantity;
    }
}
