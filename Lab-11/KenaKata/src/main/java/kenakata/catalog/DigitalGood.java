package kenakata.catalog;

public class DigitalGood extends CatalogItem {

    public DigitalGood(String sku, String title, long unitPrice, int stock, Seller seller) {
        super(sku, title, unitPrice, stock, seller);
    }

    @Override
    public long unitVat() {
        return (long) 0;
    }

    @Override
    public long commissionOn(long lineValue) {
        return (long) 0;
    }
}

