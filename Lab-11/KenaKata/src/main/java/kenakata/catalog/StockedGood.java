package kenakata.catalog;

public class StockedGood extends CatalogItem{
    private final int weightGrams;

    public StockedGood(String sku, String title, long unitPrice, int stock, Seller seller, int weightGrams){
        super(sku, title, unitPrice, stock, seller);
        if (weightGrams < 0) {
            throw new IllegalArgumentException("Weight cannot be negative.");
        }
        this.weightGrams = weightGrams;
    }
    @Override
    public long getVatPerUnit() {
        return (long) Math.ceil(getUnitPrice() * 0.075);
    }

    @Override
    public double getCommissionRate(){
        return 0.08;
    }

    @Override
    public boolean hasWeight(){
        return true;
    }

    @Override
    public int getWeightGramsPerUnit(){
        return weightGrams;
    }

    @Override
    public boolean isInsurable(){
        return true;
    }

    @Override
    public boolean isReturnable(){
        return true;
    }
}