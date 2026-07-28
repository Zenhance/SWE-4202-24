package kenakata.catalog;

import kenakata.exceptions.InsufficientStockException;

public class StockedGood extends Product{
    private double weightGrams;
    public StockedGood(String sku, String title, double unitPrice, int stock, Seller seller, double weightGrams) throws InsufficientStockException {
        super(sku, title, unitPrice, stock, seller);

        if (weightGrams <= 0) {
            throw new IllegalArgumentException("Weight must be greater than zero in grams.");
        }

        this.weightGrams = weightGrams;
    }
}
