package kenakata.catalog;

public class FreshGood extends CatalogItem implements Chargeable{
    private int weight;

    FreshGood(String sku, String title, long unitPrice, int stock, Seller seller) {
        super(sku, title, unitPrice, stock, seller);
        this.weight=weight;
    }

    public int getWeight() {
        return weight;
    }

    public long unitVat() {
        return 0;
    }
    @Override
    public long commissionOn(int amount) {
        return (long) Math.ceil(amount * 0.05);
    }

}
