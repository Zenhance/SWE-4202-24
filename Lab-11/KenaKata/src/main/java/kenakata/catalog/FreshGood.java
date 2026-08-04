package kenakata.catalog;

public class FreshGood extends CatalogItem implements ColdChain,Returnable{
    private static final double comission_rate=0.05;
    private static final double vat=0.0;
    private static final int window_day=2;
    private static final long cold_chain_surcharge=50;
    private final int weightgrams;
    public FreshGood(String sku, String title, long unitprice, int livestock, Seller seller , int weightgrams) {
        super(sku, title, unitprice, livestock, seller);
        if(weightgrams<=0){
            throw new IllegalArgumentException("It is not valid");
        }
        this.weightgrams=weightgrams;
    }

    @Override
    public long unitVat() {
        return 0;
    }

    @Override
    public long commissionOn(long amount) {
        return (long)Math.ceil(amount*comission_rate);
    }

    @Override
    public int returnWindowDays() {
        return window_day;
    }



    @Override
    public long ColdChainSurcharge() {
        return cold_chain_surcharge;
    }
}
