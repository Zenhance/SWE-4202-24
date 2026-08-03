package kenakata.catalog;

public class FreshGood extends CatalogItem implements ColdChain{
    public FreshGood(String SKU, String TITLE, int UnitPrize, int StockCount, Seller seller) {
        super(SKU,TITLE,UnitPrize,StockCount,seller);
    }

    @Override
    public long coldChainCharge() {
        return 50;
    }

    @Override
    public long unitCharge() {
        return 0;
    }

    @Override
    public int commissionOn() {
        return 0;
    }

    @Override
    public long unitVat() {
        return 0;
    }

    @Override
    public void reserve() {

    }
}
