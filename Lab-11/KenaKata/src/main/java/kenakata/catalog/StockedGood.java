package kenakata.catalog;

public class StockedGood extends CatalogItem implements Weight, Insurable, Returnable{
    private final int weight;
    public StockedGood(String SKU, String TITLE, int UnitPrize, int StockCount, Seller seller,int weight) {
        super(SKU,TITLE,UnitPrize,StockCount,seller);
        if (weight<=0)
            throw new IllegalArgumentException();

        this.weight=weight;
    }

    public double remaining() {
        return 2;

    }

    @Override
    public long unitCharge() {
        return 0;
    }

    @Override
    public int commissionOn(int i) {
        return 0;
    }

    public long unitVat() {
    return (long) (UnitePrize*0.075);}

    @Override
    public void reserve(int quantity) {
    }
}
