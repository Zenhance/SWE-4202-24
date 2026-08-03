package kenakata.catalog;

public final class DigitalGood extends CatalogItem {
    public DigitalGood(String sku, String title, long unitPrice, int stock, Seller seller) {
        super(sku, title, unitPrice, stock, seller);
    }

    @Override
    public long unitVat() {
        return unitCharge();
    }

    @Override
    public long commissionOn(long lineValue) {
        return MoneyMath.ceilRate(lineValue, 20, 100);
    }
}
