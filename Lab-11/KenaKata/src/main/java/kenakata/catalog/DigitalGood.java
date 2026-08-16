package kenakata.catalog;

public class DigitalGood extends CatalogItem implements Chargeable {
    public DigitalGood(String sku, String title, long unitPrice, int stock, Seller seller) {
        super(sku,  title, unitPrice, stock, seller);
    }

    public long unitCharge() {
        return getUnitPrice();
    }

    public long unitVat() {
        return (long) Math.ceil(getUnitPrice() * 0.05);
    }

    public long commissionOn(long amount) {
        return (long) Math.ceil(amount * 0.2);
    }
}
