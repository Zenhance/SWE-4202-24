package kenakata.catalog;

public class StockedGood extends CatalogItem  {

    private final int weightGrams;

    public StockedGood(String sku, String title, long price, int stock, Seller seller, int weightGrams){
        super(sku, title, price, stock, seller);
        this.weightGrams=weightGrams;
    }
    public int WeightGrams(){
        return weightGrams;
    }




    public long unitCharge() {
        return 0;
    }

    public long unitVat() {
   return 0; }

    public int commissionOn(int i) {
        return 0;
    }

    public void reserve(int i) {
    }

    public int remaining() {
        return 0;
    }
}
