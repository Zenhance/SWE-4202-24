package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public class DigitalGood extends Product{
    public DigitalGood(String sku, String title, long unitPrice, int stock, Seller seller) throws OutOfStockException {
        super(sku, title, unitPrice, stock, seller);
    }

    @Override
    public long unitVat() {
        return (long) Math.ceil(unitPrice()*0.05);
    }

    @Override
    public long commissionOn() {
        return (long) Math.ceil(unitPrice()*0.2);
    }
}
