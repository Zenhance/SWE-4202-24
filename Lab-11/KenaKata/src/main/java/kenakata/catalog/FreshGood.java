package kenakata.catalog;

public class FreshGood extends CatalogItem {

    private final int weight;

    public FreshGood(String sku, String title, long unitPrice, int stock, Seller seller, int weight) {
        super(sku, title, unitPrice, stock, seller);

        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.weight = weight;
    }

    public int weight() {
        return weight;
    }


    @Override
    public long unitVat() {
        return 0;
    }

    @Override
    public long commissionOn(long lineValue) {
        return (long) Math.ceil(lineValue * 0.05);
    }
}

