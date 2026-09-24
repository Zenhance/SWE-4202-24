package kenakata.catalog;

public class StockedGood extends CatalogItem {

    private final int weightGrams;

    public StockedGood(String sku, String title, long price, int stock, Seller seller, int weightGrams) {
        super(sku, title, price, stock, seller);
        this.weightGrams = weightGrams;
    }

    public int weightGrams() {
        return weightGrams;
    }

    @Override
    public long commissionOn(long lineValue) {
        return Math.round(lineValue * 0.08);
    }

    @Override
    public long unitVat() {
        return Math.round(price * 0.075);
    }
}