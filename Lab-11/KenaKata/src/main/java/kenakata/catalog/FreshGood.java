package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public class FreshGood extends CatalogItem {

    private int stock;
    private final long weightGrams;

    public FreshGood(String sku, String label, long unitPrice, int stock, Seller seller, long weightGrams) {
        super(sku, label, unitPrice, seller);
        this.stock = stock;
        this.weightGrams = weightGrams;
    }

    public void reserve(int qty) throws OutOfStockException {
        if(qty <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        if(qty > stock) {
            throw new OutOfStockException("Not enough stock");
        }
        stock -= qty;
    }

    public int remaining() {
        return stock;
    }

    public long weightGrams() {
        return weightGrams;
    }
    @Override
    public long unitVat() {
        return 0;
    }

    @Override
    public long commissionOn(long lineValue) {
        return (long)Math.ceil(lineValue * 0.05);
    }
}
