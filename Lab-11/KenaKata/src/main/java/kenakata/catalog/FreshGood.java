package kenakata.catalog;

public class FreshGood extends CatalogItem implements Weighable, ColdChain, Insurable, Returnable{
    public FreshGood(String sku, String title, double unitPrice, int stockRemaining, Seller seller) {
        super(sku, title, unitPrice, stockRemaining, seller);
    }

    public double unitVat(){
        return 0.0;
    }
    public double commisionOn(double lineValue){
        return lineValue;
    }
    public int unitWeight(){
        return 0;
    }
    public int returnWindowDays(){
        return 0;
    }
}
