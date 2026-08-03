package kenakata.catalog;

import kenakata.util.Money;

public final class StockedGood extends CatalogItem implements Weighable, Insurable, Returnable, Discountable {

    private final long weightGrams;

    public StockedGood(String sku, String title, long unitPrice, int stock, Seller seller, long weightGrams) {
        super(sku, title, unitPrice, stock, seller);

        this.weightGrams = weightGrams;
    }