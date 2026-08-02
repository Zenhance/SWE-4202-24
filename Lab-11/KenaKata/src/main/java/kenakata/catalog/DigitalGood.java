package kenakata.catalog;

public class DigitalGood extends CatalogItem {
    public DigitalGood(String sku, String name, long price, long stock, Seller seller) {
        super(sku, name, price, seller);
    }
    @Override
    public long unitVat() {
        return (unitCharge() * 5 + 99) / 100;
    }
    @Override
    public long commissionOn(long amount) {
        return (amount * 20 + 99) / 100;
    }
}