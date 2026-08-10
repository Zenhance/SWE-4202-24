package kenakata.catalog;

public class DigitalGood extends CatalogItem{

    public DigitalGood(String sku, String title, long unitPrice, int liveStock, Seller seller) {
        super(sku, title, unitPrice, liveStock, seller);
    }

    @Override
    public long commissionOn(long i) {
        return (long) (i*.20);
    }

    @Override
    public long unitVat() {
        return (long) Math.ceil(getUnitPrice() * 0.05);
    }

    @Override
    public String label() {
        return "";
    }
}
