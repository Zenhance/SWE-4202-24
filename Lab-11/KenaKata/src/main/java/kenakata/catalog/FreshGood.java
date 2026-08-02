package kenakata.catalog;

public class FreshGood extends CatalogItem{
    private final int weight;

    public FreshGood(String sku, String title, long price, int stock, Seller seller, int weight) {
        super(sku, title, price, stock, seller);
        this.weight=weight;
    }
}
