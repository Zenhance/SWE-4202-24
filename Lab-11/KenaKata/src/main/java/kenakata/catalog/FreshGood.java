package kenakata.catalog;


public class FreshGood extends Item{
    private final int weight;

    public FreshGood(String sku, String title, long unitPrice, int stock, Seller seller,int weight){
        super(sku, title, unitPrice, stock, seller);

        if(weight <= 0)
            throw new IllegalArgumentException();

        this.weight = weight;

    }

    public int weight() {
        return weight;
    }

    @Override
    public long unitCharge() {
        return super.unitCharge();
    }

    @Override
    public long unitVat() {
        return 0;
    }

    @Override
    public long commissionOn(long n) {
        return (long)Math.ceil(n * 0.05);
    }

}
