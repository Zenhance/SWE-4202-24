package kenakata.catalog;

public class StockedGood extends CatalogItem implements Weighable,Insurable,Returnable{
 private  final int weightGrams;
 public StockedGood( String sku, String title, long unitPrice, int stock, Seller seller, int weightGrams){
     super(sku,title,unitPrice,stock,seller);
     if(weightGrams<=0){
         throw new IllegalArgumentException("Weight must be positive");
     }
     this.weightGrams=weightGrams;
 }
 @Override
 public int weightGrams(){
     return weightGrams;
 }

 @Override
 public  long unitVat( ){
     return  (long)Math.ceil(unitCharge()*0.075);
 }

 @Override
 public long commissionOn(long lineValue){
      return  (long)Math.ceil(lineValue*0.08);
 }

 @Override
 public long insurableValue(int quantity){
        return unitCharge()*quantity;
    }
 @Override
 public int returnWindowDays(){
     return 7;
 }

}

