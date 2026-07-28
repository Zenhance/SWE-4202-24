package kenakata.catalog;

import kenakata.catalog.capabilities.Weighable;
import kenakata.exceptions.InsufficientStockException;

public class StockedGood extends Product implements Weighable {
    private double weightGrams;
    private final double vat;

    public StockedGood(String sku, String title, double unitPrice, int stock, Seller seller, double weightGrams, double vat) throws InsufficientStockException {
        super(sku, title, unitPrice, stock, seller);

        if (weightGrams <= 0) {
            throw new IllegalArgumentException("Weight must be greater than zero in grams.");
        }

        this.weightGrams = weightGrams;
        this.vat = 0.075;
    }
}
