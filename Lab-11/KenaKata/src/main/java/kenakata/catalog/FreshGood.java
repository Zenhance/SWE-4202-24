package kenakata.catalog;

import kenakata.util.Money;

public final class FreshGood extends CatalogItem implements Weighable, ColdChain, Insurable, Returnable {

    private final long weightGrams;

    public FreshGood(String sku, String title, long unitPrice, int stock, Seller seller, long weightGrams) {
        super(sku, title, unitPrice, stock, seller);
        this.weightGrams = weightGrams;
    }
    @Override
    public long unitVat() {
        return 0;
    }

    @Override
    public long commissionOn(long lineValue) {
        return 0;
    }

    @Override
    public long weightGrams() {
        return weightGrams;
    }

    @Override
    public long coldChainSurcharge() {
        return 0;
    }

    @Override
    public long insurableValue() {
        return unitPrice();
    }

    @Override
    public int returnWindowDays() {
        return 0;
    }
}