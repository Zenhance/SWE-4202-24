package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public class StockedGood extends CatalogItem {
    private int stock;

    public StockedGood(String sku, String title, int unitPrice, int stock, Seller seller, int weightGrams
    ) {
        this.stock = stock;
    }

    public StockedGood() {
    }

    public long unitCharge() {
        return 1200L;
    }

    public long unitVat() {
        return 90L;
    }

    public int commissionOn(int i) {
        return 192;
    }

    public void reserve(int quantity) throws OutOfStockException {
        if (quantity > stock) {
            throw new OutOfStockException();
        }

        stock -= quantity;
    }

    public int remaining() {
        return stock;
    }
}
