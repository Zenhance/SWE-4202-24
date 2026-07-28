package kenakata.catalog;

public final class StockedGood extends CatalogItem implements Weighable, Insurable, Returnable, Discountable{
    private final int unitWeightGrams;
    public StockedGood(String sku, String title, long unitPrice, int stock, Seller seller, int unitWeightGrams){
        super(sku,title,unitPrice,stock,seller);
        if(unitWeightGrams<=0){
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.unitWeightGrams = unitWeightGrams;
    }
    @Override
    public long unitVat(){
        return MoneyMath.ceilFraction(unitPrice(),75,1000);
    }
    @Override
    public long commissionOn(long lineValue){
        if(lineValue < 0){
            throw new IllegalArgumentException("Line value cannot be negative");
        }
        return MoneyMath.ceilPercent(lineValue,8);
    }
    @Override
    public int unitWeightGrams(){
        return unitWeightGrams;
    }
    @Override
    public long insurableValue(int quantity){
        if(quantity<=0){
            throw new IllegalArgumentException("Quantity must be positive");
        }
        return Math.multiplyExact(unitPrice(),quantity);
    }
    @Override
    public int returnWindowDays(){
        return 7;
    }
}
