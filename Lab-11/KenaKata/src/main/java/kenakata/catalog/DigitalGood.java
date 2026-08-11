package kenakata.catalog;

public class DigitalGood extends CatalogItem implements Chargeable{
    public DigitalGood(String sku, String title, long unitPrice, int stock, Seller seller) {
        super(sku, title, unitPrice, stock, seller);
    }

    public long unitCharge() {
        return 1;
    }

    public long unitVat() {
        return (long) Math.ceil( getUnitPrice()*.05);
    }

    public int commissionOn(int i) {
        return 1;
    }
}
