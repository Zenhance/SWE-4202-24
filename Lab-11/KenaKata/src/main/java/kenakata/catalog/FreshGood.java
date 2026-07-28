package kenakata.catalog;

public final class FreshGood extends CatalogItem implements Weighable, ColdChain, Insurable, Returnable{
    private static final long COLD_CHAIN_FEE = 50;
    private final int unitWeightGrams;
    public FreshGood(String sku, String title, long unitPrice, int stock, Seller seller, int unitWeightGrams){
        super(sku,title,unitPrice,stock,seller);
        if(unitWeightGrams<=0){
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.unitWeightGrams = unitWeightGrams;
    }
@Override
    public long unitVat(){
        return 0;
}
@Override
    public long commissionOn(long lineValue){
        if(lineValue<0){
            throw new IllegalArgumentException("Line value cannot be negative");
        }
        return MoneyMath.ceilPercent(lineValue,5);
}
@Override
    public int unitWeightGrams(){
        return unitWeightGrams;
}
@Override
    public long coldChainSurcharge(){
        return COLD_CHAIN_FEE;
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
        return 2;
}
}
