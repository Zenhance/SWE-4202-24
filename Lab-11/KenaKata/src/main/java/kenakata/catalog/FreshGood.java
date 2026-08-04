package kenakata.catalog;

public class FreshGood extends CatalogItem implements Weight,Insurable,Returnable,ColdChain{
    private final int weight;
    public FreshGood(String SKU, String TITLE, int UnitPrize, int StockCount, Seller seller,int weight) {
        super(SKU,TITLE,UnitPrize,StockCount,seller);
        if (weight<=0)
            throw new IllegalArgumentException();
        this.weight=weight;
    }

    @Override
    public long coldChainCharge() {
        return 50;
    }

    @Override
    public long unitCharge() {
        return UnitePrize;
    }

    @Override
    public int commissionOn(int i) {
        return (int) (i*0.05);
    }

    @Override
    public int weight() {
        return weight;
    }

    @Override
    public long unitVat() {
        return 0;
    }

    @Override
    public void reserve(int quantity) {
    }


    @Override
    public long insurableValue() {
        return 0;
    }
}
