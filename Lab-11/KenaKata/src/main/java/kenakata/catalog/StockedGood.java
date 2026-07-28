package kenakata.catalog;

public final class StockedGood extends CatalogItem implements Weighable, Insurable, Returnable, Discountable{
    private final int unitWeightGrams;
    private StockedGood(String sku, String title, long unitPrice, int stock, Seller seller, int unitWeightGrams){
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
    public long comissionOn(long lineValue){
        if(lineValue < 0){
            throw new IllegalArgumentException("Line value cannot be negative");
        }
        return MoneyMath.ceilPercent(lineValue,8);
    }
    @Override
    public int unitWeightGrams(){
        return unitWeightGrams;
    }
}
