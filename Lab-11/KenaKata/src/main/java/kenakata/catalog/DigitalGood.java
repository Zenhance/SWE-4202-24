package kenakata.catalog;

public class DigitalGood extends CatalogItem{
    public DigitalGood(String SKU, String TITLE, int UnitPrize, int StockCount, Seller seller) {
        super(SKU,TITLE,UnitPrize,StockCount,seller);
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
