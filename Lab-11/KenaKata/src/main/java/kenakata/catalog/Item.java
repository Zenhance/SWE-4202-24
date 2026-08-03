package kenakata.catalog;

public class Item {
    private String SKU;
    private String title;
    private double unitPrice;
    private int stockCount;
    private Seller seller;
    private int weight;


    public Item(String SKU, String title, double unitPrice, int stockCount, Seller seller, int weight) {
        this.SKU = SKU;
        this.title = title;
        this.unitPrice = unitPrice;
        this.stockCount = stockCount;
        this.seller = seller;
        this. weight = weight;
    }

    public int remaining() {
        return stockCount;
    }





}
