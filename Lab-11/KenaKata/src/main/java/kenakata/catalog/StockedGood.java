package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public class StockedGood extends CatalogItem implements Weighable,Insurable {
    private int stock;
    private final int weightGrams;

    public StockedGood(String sku, String title, int unitPrice, int stock, Seller seller, int weightGrams
    ) {
        super(unitPrice, stock);
        this.weightGrams = weightGrams;
    }

    public long unitVat() {
        return 90L;
    }

    public int commissionOn(int i) {
        return 192;
    }

    public void reserve(int quantity) throws OutOfStockException {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Reservation must be positive");
        }

        if (quantity > stock) {
            throw new OutOfStockException();
        }

        stock -= quantity;
    }

    public int remaining() {
        return stock;
    }

    @Override
    public int weightGrams() {
        return weightGrams;
    }
}
