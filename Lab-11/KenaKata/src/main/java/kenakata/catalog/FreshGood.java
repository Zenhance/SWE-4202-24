package kenakata.catalog;

import kenakata.util.Money;

public final class FreshGood extends CatalogItem implements Weighable, ColdChain, Insurable, Returnable {

    private final long weightGrams;

    public FreshGood(String sku, String title, long unitPrice, int stock, Seller seller, long weightGrams) {
        super(sku, title, unitPrice, stock, seller);
        this.weightGrams = weightGrams;
    }