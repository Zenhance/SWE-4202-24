package kenakata.catalog;

public class FreshGood extends CatalogItem {

    private final int days;
    public FreshGood(String sku, String title,long price, int stock, Seller seller, int days) {

        super(sku,title,price, stock, seller);
        this.days = days;
    }

    public int unitVat() {
        return 0;
    }

    public int commissionOn(int i) {
        return 0;
    }
}
