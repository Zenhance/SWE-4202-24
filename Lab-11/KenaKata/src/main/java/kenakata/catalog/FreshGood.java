package kenakata.catalog;


public class FreshGood extends Item{

    public FreshGood(String sku, String title, long unitPrice, int stock, Seller seller){
        super(sku, title, unitPrice, stock, seller);
    }

    public int unitCharge(){
        return unitPrice;
    }

    public int unitVat(){
        return ceil(unitPrice*0%);
    }

    public int commissionOn(int n){
        return ceil(n*5%);
    }

}
