package kenakata.catalog;

public class FreshGood extends CatalogItem{
    private final int weightGrams;
    public FreshGood(int sku,String title,int unitPrice,int stockCount,Seller seller){
        super(sku,title,unitPrice,stockCount,seller);
        if(weightGrams<=0){
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.weightGrams=weightGrams;
    }
    public long unitVat(){
        return 0;
    }

    @Override
    public boolean isDiscountable() {
        return false;
    }

    @Override
    public boolean isWeighable() {
        return true;
    }

    @Override
    public int weightGrams() {
        return 0;
    }

    @Override
    public boolean needsColdChain() {
        return true;
    }

    @Override
    public boolean isInsurable() {
        return false;
    }

    @Override
    public boolean isReturnable() {
        return true;
    }

    @Override
    public int returnWindowDays() {
        return 2;
    }

    @Override
    public long commissionOn(long lineValue) {
        return (long)Math.ceil(lineValue*0.05);
    }
}
