package kenakata.catalog;

public class StockedGood extends CatalogItem
         implements Weighable, Insurable, Returnable{
    private final int weight;
    public StockedGood(String sku,String title,long unitPrice,int stock,Seller seller,int weight){
        super(sku, title, unitPrice, stock, seller);
        if(weight<=0){
            throw new IllegalArgumentException();
        }
        this.weight=weight;
    }

    @Override
    public int weightGrams() {
        return weight;
    }

    @Override
    public int returnWindowDays() {
        return 7;
    }

    @Override
    public long insurableValue(int quantity) {
        if(quantity<=0){
            throw new IllegalArgumentException();
        }
        return unitPrice*quantity;
    }

    @Override
    public long unitVat() {
        return Math.round(unitPrice*0.075);
    }

    @Override
    public long commissionOn(long value) {
        return Math.round(value*0.08);
    }
}


