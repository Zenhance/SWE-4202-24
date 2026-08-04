package kenakata.catalog;

public class StockedGood extends CatalogItem implements Weightable, Insurable, Returnable {
    private final int weightGrams;
    public StockedGood(String sku, String name, long unitPrice, int stock, Seller seller, int weightGrams){
        super(sku, name, unitPrice, stock, seller);
        if(weightGrams<=0){
            throw new IllegalArgumentException("Weight must be positive!");
        }
        this.weightGrams= weightGrams;
    }
    public int weightGrams(){
        return weightGrams;
    }
    public long unitVat() {
        return (long)Math.ceil(unitCharge()*0.075);
    }

    public  long commissionOn(long i) {
        return (long)Math.ceil(i*0.08);
    }

    public long calInsurance(int quantity){
        return unitCharge()*quantity;
    }
    public int returnWindowDays(){
        return 7;
    }
}

