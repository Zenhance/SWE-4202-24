package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

import static java.lang.Math.ceil;

public class StockedGood extends CatalogItem{
    int weight,stock;
    public StockedGood(String SKU, String title, int unitprice, int stock, Seller s1, int Weight){
        super(SKU,title,unitprice,stock,s1);
        if(Weight<=0) throw new IllegalArgumentException();

        this.weight = Weight;
    }


    public int getWeight() {
        return weight;
    }



    @Override
    public int unitVat() {
        return (int) ceil(unitprice*0.075);
    }
    @Override
    public int commissionOn(int total) {
        return (int) ceil(total*0.08);
    }
}
