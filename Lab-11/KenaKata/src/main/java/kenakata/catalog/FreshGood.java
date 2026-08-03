package kenakata.catalog;

import kenakata.catalog.capabilities.Coldchainable;
import kenakata.catalog.capabilities.Insurable;
import kenakata.catalog.capabilities.Returnable;
import kenakata.catalog.capabilities.Weighable;
import kenakata.exceptions.OutOfStockException;

public class FreshGood extends Product implements Weighable, Coldchainable, Insurable, Returnable {

    private final int weightInGrams;
    public FreshGood(String sku, String title, long unitPrice, int stock, Seller seller, int weightInGrams) throws OutOfStockException {
        super(sku, title, unitPrice, stock, seller);
        this.weightInGrams = weightInGrams;
    }

    @Override
    public int weightInGrams() { return weightInGrams;}

    @Override
    public long unitVat() {
        return 0;
    }

    @Override
    public long commissionOn() {
        return (long) Math.ceil(unitCharge()*0.05);
    }

    @Override
    public long insurableValue() {
        return unitPrice();
    }

    @Override
    public long coldChairSurcharge() {
        return 50;
    }

    @Override
    public int returnWindowDays() {
        return 2;
    }


}
