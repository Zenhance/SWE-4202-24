package kenakata.catalog;

public class Item implements Chargeable{
    private String SKU;
    private String title;
    private double unitPrice;
    private int stockCount;
    private Seller seller;


    public Item(String SKU, String title, double unitPrice, int stockCount, Seller seller) {
        if (SKU == null || title == null || seller == null) {
            throw new IllegalArgumentException("Invalid identity data");
        }
        if (unitPrice < 0 || stockCount < 0) {
            throw new IllegalArgumentException("Negative price or stock");
        }
        this.SKU = SKU;
        this.title = title;
        this.unitPrice = unitPrice;
        this.stockCount = stockCount;
        this.seller = seller;
    }

    public String getSKU() {
        return SKU;
    }

    public String getTitle() {
        return title;
    }

    public Seller getSeller() {
        return seller;
    }

    public int remaining() {
        return stockCount;
    }

    @Override
    public long unitCharge() {
        return unitPrice;
    }
    @Override
    public String label() {
        return title;
    }

    public void reserve(int quantity) throws OutOfStockException {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");
        if (quantity > stock) throw new OutOfStockException("Insufficient stock for " + title);
        stock -= quantity;
    }





}
