package kenakata.catalog;

public class FreshGood extends CatalogItem
         implements Weighable,ColdChain,Insurable,Returnable{
    private final int weight;
    public FreshGood(String sku,String title,long unitPrice,int stock,Seller seller,int weight){
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
    public long coldChainCharge() {
        return 50;
    }

    @Override
    public int returnWindowDays() {
        return 2;
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
        return 0;
    }

    @Override
    public long commissionOn(long value) {
        return Math.round(value*0.05);
    }

}
