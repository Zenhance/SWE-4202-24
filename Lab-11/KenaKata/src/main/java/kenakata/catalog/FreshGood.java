package kenakata.catalog;

public class FreshGood extends StockedGood {
    public FreshGood(String sku, String title, int unitPrice, int stock, Seller seller, int weightGrams) {
        super(sku, title, unitPrice, stock, seller, weightGrams);
    }

    @Override
    public long unitVat() {
        return 0L;
    }

    public int commissionOn(int i) {
        return 80;
    }
}
