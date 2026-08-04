package kenakata.catalog;

public class FreshGood extends CatalogItem implements Chargeable,Weightable,Returnable,Insurable{

    protected int weight;

    public FreshGood(String sku, String title, long unitPrice, int stock, Seller seller, int weight){
        super(sku, title, unitPrice, stock, seller);
        if(weight<0) throw new IllegalArgumentException("Weight can't be negative");
        this.weight = weight;
    }

    @Override
    public long unitVat() {
        return 0;
    }
    @Override
    public long commissionOn(int amount) {
        return (long) Math.ceil(amount * 0.05);
    }

    @Override
    public double weight() {
        return weight;
    }
    @Override
    public int returnWindow() {
        return 2;
    }

    @Override
    public long insure(long quantity) {
        return unitPrice*quantity;
    }
}
