package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public class StockedGood extends CatalogItem{

    public StockedGood(String a, String itemType, int unitPrice, int amount, Seller s, int weight) {
        super(a, itemType, unitPrice, amount, s, weight);
    }


    public int unitVat() {
        double x = Math.ceil(unitPrice*0.075);
        return (int) x ;
    }

    public int commissionOn(int i) {
        double x = Math.ceil(i*0.08);
        return (int) x;
    }




}
