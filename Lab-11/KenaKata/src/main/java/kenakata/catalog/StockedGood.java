package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public class StockedGood extends CatalogItem {

     private int stock;
     private final long weightGrams;

    public StockedGood(String sku, String label, long unitPrice, int stock, Seller seller, long weightGrams) {
        super(sku, label, unitPrice, seller);
        if(stock < 0 || weightGrams <= 0) {
            throw new IllegalArgumentException("Invalid stock/weight");
        }
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
        return (long)Math.ceil(unitPrice * 0.075);
    }

    @Override
    public long commissionOn(long lineValue) {
        return (long)Math.ceil(lineValue * 0.08);
    }
}
