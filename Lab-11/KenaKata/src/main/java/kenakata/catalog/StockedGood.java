package kenakata.catalog;

public class StockedGood extends CatalogItem {
    private final int weight;

    public StockedGood(String sku, String title, long unitPrice, int initialStock, Seller seller, int weight) {
        super(sku, title, unitPrice, initialStock, seller);
        this.weight = weight;
    }
}
