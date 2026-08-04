package kenakata.catalog;

public class StockedGood extends CatalogItem {
    private final int weightGrams;

    public StockedGood(String sku, String name, long unitPrice, int stock, Seller seller, int weightGrams) {
        super(sku, name, unitPrice, stock, seller);
        if (weightGrams <= 0) {
            throw new IllegalArgumentException("Weight must be positive.");
        }
        this.weightGrams = weightGrams;
    }

    public int getWeightGrams() {
        return weightGrams;
    }

    @Override
    public long unitVat() {
                        
        return (long) Math.ceil(unitCharge() * 0.075);
    }

    @Override
    public long commissionOn(long lineValue) {
                      
        return (long) Math.ceil(lineValue * 0.08);
    }

    @Override
    public int returnWindow() {
        return 7;
    }

    @Override
    public boolean isReturnable() {
        return true;
    }

    @Override
    public boolean isInsurable() {
        return true;
    }
}