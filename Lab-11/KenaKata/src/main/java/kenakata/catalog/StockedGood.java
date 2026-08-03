package kenakata.catalog;

public class StockedGood extends CatalogItem{
    public StockedGood(String SKU, String TITLE, int UnitPrize, int StockCount, Seller seller) {
        super(SKU,TITLE,UnitPrize,StockCount,seller);
    }

    public double remaining() {
        return 2;

    }

    @Override
    public long unitCharge() {
        return 0;
    }

    @Override
    public int commissionOn() {
        return 0;
    }

    public long unitVat() {
    return 0;}

    @Override
    public void reserve() {

    }
}
