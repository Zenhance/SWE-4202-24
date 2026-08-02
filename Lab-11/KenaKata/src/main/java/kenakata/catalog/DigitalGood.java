package kenakata.catalog;

import static java.lang.Math.ceil;

public class DigitalGood extends CatalogItem {
    public DigitalGood(String SKU, String title, int unitprice, Seller seller) {
        super(SKU,title,unitprice,seller);
    }

    public DigitalGood(String SKU, String title, int unitprice, int i, Seller b) {
        super(SKU,title,unitprice,b);
    }

    @Override
    public int unitVat() {
        return (int) ceil(unitprice*0.05);
    }

    public int commissionOn(int total) {
        return (int) ceil(total*0.2);
    }
}
