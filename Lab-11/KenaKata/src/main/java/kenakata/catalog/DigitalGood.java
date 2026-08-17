package kenakata.catalog;

import static java.lang.Math.ceil;

public class DigitalGood extends CatalogItem{

    public DigitalGood(String SKU, String title, int unitprice, int stock, Seller b) {
        super(SKU,title,unitprice,stock,b);
    }

    @Override
    public int unitVat() {
        return (int) ceil(unitprice*0.05);
    }

    public int commissionOn(int total) {
        return (int) ceil(total*0.2);
    }
}
