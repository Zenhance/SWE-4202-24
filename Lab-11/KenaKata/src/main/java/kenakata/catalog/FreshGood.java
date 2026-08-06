package kenakata.catalog;

import static java.lang.Math.ceil;

public class FreshGood extends CatalogItem {
    int Stock,weight;
    public FreshGood(String SKU, String title, int unitprice, int stock, Seller seller, int Weight) {
        super(SKU,title,unitprice,seller);
        if(Weight<=0) throw new IllegalArgumentException();
        if(stock<0) throw new IllegalArgumentException();
        this.Stock = stock;
        this.weight = Weight;
    }

    @Override
    public int unitVat() {
        return 0;
    }

    @Override
    public int commissionOn(int total) {
    return (int) ceil(total*0.05);
    }
}
