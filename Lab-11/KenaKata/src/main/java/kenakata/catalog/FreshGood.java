package kenakata.catalog;

public class FreshGood extends CatalogItem implements Weighable, ColdChain, Insurable, Returnable {
    private int weightGrams;

    public FreshGood(String sku, String title, long unitPrice, int stock, Seller seller) {
        super(sku, title, unitPrice, stock, seller);
        if (weightGrams <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.weightGrams = weightGrams;
    }

    @Override
    public int weightGrams() {
        return weightGrams;
    }

    @Override
    public long unitVat() {
        return 0;
    }
}