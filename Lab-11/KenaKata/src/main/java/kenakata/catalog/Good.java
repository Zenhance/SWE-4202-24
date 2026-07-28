package kenakata.catalog;

public class Good {
    private String SKU;
    private String title;
    private double unitPrice;
    private int stockCount;
    private Seller seller;


    public Good(String SKU, String title, double unitPrice, int stockCount, Seller seller) {
        this.SKU = SKU;
        this.title = title;
        this.unitPrice = unitPrice;
        this.stockCount = stockCount;
        this.seller = seller;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
}
