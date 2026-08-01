package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public class FreshGood extends CatalogItem {

    private int stock;
    private final long weightGrams;

    public FreshGood(String sku, String label, long unitPrice, int stock, Seller seller, long weightGrams) {
        super(sku, label, unitPrice, seller);
        if(stock < 0 || weightGrams <= 0) {
            throw new OutOfStockException("Invalid stock/weight");
        }
        this.stock = stock;
        this.weightGrams = weightGrams;
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
