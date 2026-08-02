package kenakata.catalog;

public class DigitalGood extends CatalogItem{
    public DigitalGood(String sku, String title,long price, int stock, Seller seller) {
        super(sku, title, price, stock, seller);
    }

    public long unitVat() {
        return (long) Math.ceil(unitPrice() * 0.05);
    }
    public long comissionOn(long val) {
        return (long) Math.ceil(val * 0.20);
    }
}
