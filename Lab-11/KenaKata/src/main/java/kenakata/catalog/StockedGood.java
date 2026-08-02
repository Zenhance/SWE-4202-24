package kenakata.catalog;

import kenakata.catalog.capabilities.Insurable;
import kenakata.catalog.capabilities.Returnable;
import kenakata.catalog.capabilities.Weighable;
import kenakata.exceptions.OutOfStockException;

public class StockedGood extends Product implements Weighable, Returnable, Insurable {
    private int weightInGrams;

    public StockedGood(String sku, String title, long unitPrice, int stock, Seller seller, int weightGrams)
            throws OutOfStockException {
        super(sku, title, unitPrice, stock, seller);

        if (weightGrams <= 0) {
            throw new IllegalArgumentException("Weight must be greater than zero in grams.");
        }
        this.weightInGrams = weightInGrams;
    }

    @Override
    public int weightInGrams() { return weightInGrams;}
    @Override
    public long unitVat() {
        return (long) Math.ceil(unitPrice()*0.075);
    }
    @Override
    public long commissionOn() {
        return (long) Math.ceil(unitPrice()*0.08);
    }
}
