package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract  class CatalogItem implements Chargeable{
    private String SKU;
    private String title;
    private long unitPrice;
    private int stock;
    private Seller seller;


    public CatalogItem(String SKU, String title, long unitPrice, int stockCount, Seller seller) {
        if (SKU == null || title == null || seller == null) {
            throw new IllegalArgumentException("Invalid identity data");
        }
        if (unitPrice < 0 || stockCount < 0) {
            throw new IllegalArgumentException("Negative price or stock");
        }
        this.SKU = SKU;
        this.title = title;
        this.unitPrice = unitPrice;
        this.stock = stockCount;
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
        return stock;
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

    public abstract long commissionOn(long totalCharge);

    // Capabilities
    public boolean isWeighable() { return false; }
    public int weight() { return 0; }
    public boolean isFresh() { return false; }
    public boolean isDiscountable() { return false; }
    public boolean isInsurable() { return false; }
    public boolean isReturnable() { return false; }
    public int returnWindowDays() { return 0; }
}
