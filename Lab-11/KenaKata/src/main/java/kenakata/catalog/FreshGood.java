package kenakata.catalog;

public class FreshGood extends CatalogItem {

    private final int weight;
    public FreshGood(String sku,String title,long price,int stock,Seller seller,int weight) {
        super(sku,title,price,stock,seller);

        if (weight<=0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.weight = weight;
    }

    public int weight() {
        return weight;
    }

    public boolean needsColdChain() {
        return true;
    }

    @Override
    public long unitVat() {
        return 0;
    }

    @Override
    public long commissionOn(long amount) {
        return (amount*5 + 99) / 100;
    }

}