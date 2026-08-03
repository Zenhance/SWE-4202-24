package kenakata.catalog;

public class StockedGood extends Item{
    public StockedGood(String SKU, String title, double unitPrice, int stockCount, Seller seller, int weight) {
        super(SKU, title, unitPrice, stockCount, seller, weight);
    }


}
