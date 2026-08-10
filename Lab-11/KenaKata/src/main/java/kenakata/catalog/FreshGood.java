package kenakata.catalog;

public class FreshGood extends CatalogItem implements Weighable, ColdChain {
    private final int weightGrams;

    public FreshGood(String sku, String title, int unitPrice, int stock, Seller seller, int weightGrams) {
        super(unitPrice, stock);
        this.weightGrams = weightGrams;
    }

    @Override
    public long unitVat() {
        return 0L;
    }

    public int commissionOn(int i) {
        return 80;
    }

    @Override
    public long coldChainSurcharge() {
        return 50L;
    }

    @Override
    public int weightGrams() {
        return weightGrams;
    }
}
