package kenakata.catalog;

public class DigitalGood extends CatalogItem {
    public DigitalGood(String SKU, String title, int unitprice, Seller seller) {
        super(SKU,title,unitprice,seller);
    }

    public DigitalGood(String SKU, String title, int unitprice, int i, Seller b) {
        super(SKU,title,unitprice,b);
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
