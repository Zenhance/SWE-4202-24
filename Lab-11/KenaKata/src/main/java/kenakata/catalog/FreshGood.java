package kenakata.catalog;

public class FreshGood extends CatalogItem {

    private final int days;

    public FreshGood(String sku, String title, long price, int stock, Seller seller, int days) {

        super(sku, title, price, stock, seller);
        this.days = days;
    }

    @Override
    public long commissionOn(long lineValue) {
        return super.commissionOn(lineValue);
    }

    @Override
    public long unitVat() {
        return super.unitVat();
    }
}
