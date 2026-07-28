package kenakata.catalog;

import kenakata.exceptions.InsufficientStockException;

public class StockedGood extends Product{
    public StockedGood(String sku, String title, double unitPrice, int stock, Seller seller) throws InsufficientStockException {
        super(sku, title, unitPrice, stock, seller);
    }
}
