package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public class FreshGood extends CatalogItem implements Weighable, Returnable {
    private long stock;
    private long weight;

    public FreshGood(String sku, String name, long price, long stock, Seller seller, long weight) {
        super(sku, name, price, seller);

        if(stock < 0) {
            throw new IllegalArgumentException("Invalid stock");
        }
        if(weight <= 0) {
            throw new IllegalArgumentException("Invalid weight");
        }
        this.stock = stock;
        this.weight = weight;
    }
    public long remaining() {
        return stock;
    }
    public void reserve(int quantity)
            throws OutOfStockException {
        if(quantity <= 0) {
            throw new IllegalArgumentException("Invalid quantity");
        }
        if(quantity > stock) {
            throw new OutOfStockException("Not enough stock");
        }
        stock -= quantity;
    }
    @Override
    public long weight() {
        return weight;
    }
    @Override
    public long unitVat() {
        return 0;
    }
    @Override
    public long commissionOn(long amount) {
        return (amount * 5 + 99) / 100;
    }
    @Override
    public int returnDays() {
        return 2;
    }
}