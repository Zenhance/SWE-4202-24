package kenakata.catalog;

public class StockedGood extends Good{
    public StockedGood(String SKU, String title, double unitPrice, int stockCount, Seller seller) {
        super(SKU, title, unitPrice, stockCount, seller);
    }
}
