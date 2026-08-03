package kenakata.catalog;

public class DigitalGood extends Item{
    public DigitalGood(String SKU, String title, double unitPrice, int stockCount, Seller seller) {
        super(SKU, title, unitPrice, stockCount, seller, 0);
    }
}
