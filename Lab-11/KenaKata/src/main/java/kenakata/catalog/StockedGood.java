package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

import java.util.ArrayList;

public class StockedGood extends CatalogItem implements Weighable, Insurable, Returnable{



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

    @Override
    public int getWeight(){
        return weight;
    }

    @Override
    public void returnItem(){
        returned = true;
    }

    public ArrayList<StockedGood> items2 = new ArrayList<>();
}
