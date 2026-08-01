package kenakata.catalog;

public class FreshGood extends CatalogItem {
    public FreshGood(String SKU, String title, int unitprice, int i, Seller seller, int i1) {
        super(SKU,title,unitprice,seller);
    }

    @Override
    public int unitVat() {
        return 0;
    }

    @Override
    public int unitCharge() {
        return 0;
    }

    public int commissionOn(int i) {

    }
}
