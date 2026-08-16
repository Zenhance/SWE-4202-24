package kenakata.catalog;

public class FreshGood extends CatalogItem implements Chargeable {
    int weight;
    public FreshGood(String sku, String title, long unitPrice, int stock, Seller seller, int weight) {
        super(sku, title, unitPrice, stock, seller);
        this.weight = weight;
    }

    public long unitVat() {
        return 0;
    }

    public long commissionOn(long amount) {
        return (long) Math.ceil(amount * 0.05);
    }
}
