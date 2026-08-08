package kenakata.catalog;

public class StockedGood extends CatalogItem implements Chargeable {
    private int weightGrams;

    StockedGood(String sku, String title, long unitPrice, int stock, Seller seller, int weightGrams) {
        super(sku, title, unitPrice, stock, seller);
        if(weightGrams<=0)
            throw new IllegalArgumentException("weight must be positive");
        this.weightGrams=weightGrams;
    }


    public int getWeightGrams() {
        return weightGrams;
    }

    @Override
    public long unitVat() {
        return (long)Math.ceil(weightGrams*0.075);
}
    @Override
    public long commissionOn(int amount) {
        return (long) Math.ceil(amount*0.08);
    }
}
