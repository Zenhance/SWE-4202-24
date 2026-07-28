package kenakata.catalog;

public class DigitalGood extends CatalogItem {


    public DigitalGood(String sku, String title, long price, int stock, Seller seller) {
        super(sku, title, price, stock, seller);
    }

    @Override
    public long unitVat() {
        return ceilPercent(unitCharge(), 5);
    }

    @Override
    public long commissionOn(long amount) {
        return ceilPercent(amount, 20);
    }

    private long ceilPercent(long value, double percent) {
        return (long)Math.ceil(value * percent / 100.0);
    }
}