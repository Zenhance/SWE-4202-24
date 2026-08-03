package kenakata.catalog;

public class StockedGood extends CatalogItem {
    private final int weight;

    public StockedGood(String sku,String title,long price,int stock,Seller seller,int weight) {

        super(sku,title,price,stock,seller);

        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive");}

        this.weight = weight;
    }

    public int weight() {
        return weight;
    }

    @Override
    public long unitVat() {
        return (price*75 + 999)/1000;
    }

    @Override
    public long commissionOn(long amount) {
        return (amount*8 + 99)/100;
    }

}