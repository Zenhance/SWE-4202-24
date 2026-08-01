package kenakata.catalog;

public class DigitalGood extends CatalogItem {

    private final int stock;

    public DigitalGood(String sku, String label, long unitPrice, int stock, Seller seller) {
        super(sku, label, unitPrice, seller);
        this.stock = stock;
    }

    @Override
    public long unitVat() {
        return (long)Math.ceil(unitPrice * 0.05);
    }

    @Override
    public long commissionOn(long lineValue) {
        return (long)Math.ceil(lineValue * 0.20);
    }

}
