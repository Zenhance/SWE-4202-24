package kenakata.catalog;


public class StockedGood extends Item{
    private final int weight;

    public StockedGood(String sku, String title, long unitPrice, int stock, Seller seller,int weight){
        super(sku, title, unitPrice, stock, seller);

        if (weight <= 0) {
            throw new IllegalArgumentException();
        }

        this.weight = weight;
    }

    @Override
    public long unitCharge() {
        return super.unitCharge();
    }

    public long unitVat(){
        return (long)Math.ceil(unitPrice*0.075);
    }

    public long commissionOn(int n){
        return (long)Math.ceil(n*0.008);
    }

    public int weight(){
        return weight;
    }

}
