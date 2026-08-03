package kenakata.catalog;

public class StockedGood extends CatalogItem{
   private final int weightGrams;
   public StockedGood(int sku,String title,int unitPrice,int stockCount,Seller seller,int weightGrams){
       super(sku, title, unitPrice, stockCount);
       if(weightGrams<=0){
           throw new IllegalArgumentException("Weight must be positive");
       }
       this.weightGrams=weightGrams;
   }

    @Override
    public boolean isDiscountable() {
        return true;
    }
    public long unitVat(){
       return (long) Math.ceil(unitCharge()*0.075);
    }
    public boolean isWeighable(){
       return true;
    }
    public int weightGrams(){
       return weightGrams;
    }

    @Override
    public boolean isInsurable() {
        return true;
    }
    public boolean needsColdChain(){
       return false;
    }

    @Override
    public boolean isReturnable() {
        return true;
    }
    public int returnWindowDays(){
       return 7;
    }
    public long commissionOn(long lineValue){
       return (long) Math.ceil(lineValue*0.08);
    }
}
