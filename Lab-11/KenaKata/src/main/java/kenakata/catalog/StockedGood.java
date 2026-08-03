package kenakata.catalog;

public class StockedGood extends CatalogItem implements Weighable, Insurable, Returnable{
    private final int weightGrams;

    public StockedGood(String sku, String title, long unitPrice, int stock, Seller seller, int weightGrams){
        super (sku, title, unitPrice, stock, seller);
        if(weightGrams<=0){
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.weightGrams= weightGrams;
    }

    @Override
    public int weightGrams() {
        return weightGrams;
    }

    @Override
    public long unitVat() {
        return (unitPrice() * 75 + 999)/1000;
    }

    @Override
    public long commissionOn(long lineValue) {
        return (lineValue * 8 + 99)/100;
    }

    @Override
    public long insurableValue(int quantity) {
        return unitPrice() * quantity;
    }

    @Override
    public int returnWindowDays() {
        return 7;
    }
}
