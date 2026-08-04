package kenakata.catalog;

import java.io.Serializable;

public class StockedGood extends CatalogItem implements Weighable, Returnable {


    public StockedGood(String sku, String title, double unitPrice, int stockRemaining, Seller seller) {
        super(sku, title, unitPrice, stockRemaining, seller);
    }

    public double unitVat(){
        return 0;
    }
    public double commisionOn(double lineValue){
        return 0;
    }
    public int unitWeight(){
        return 0;
    }
    public int returnWindowDays(){
        return 0;
    }

}
