package kenakata.catalog;

public class DigitalGood extends CatalogItem {
    public DigitalGood(String SKU, String TITLE, int UnitPrize, int StockCount, Seller seller) {
        super(SKU,TITLE,UnitPrize,StockCount,seller);
    }

    @Override
    public long unitCharge() {
        return 0;
    }

    @Override
    public int commissionOn(int i) {
        return (int) Math.ceil(i*0.2);
    }

    @Override
    public long unitVat() {
        return UnitePrize*8;
    }

    @Override
    public void reserve(int quantity) {

    }
}
