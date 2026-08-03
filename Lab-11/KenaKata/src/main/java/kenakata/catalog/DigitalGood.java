package kenakata.catalog;


public class DigitalGood extends Item{

    public DigitalGood (String sku, String title, long unitPrice, int stock, Seller seller){
        super(sku, title, unitPrice, stock, seller);
    }

    public int unitCharge(){
        return unitPrice;
    }

    public int unitVat(){
        return ceil(unitPrice*5%);
    }

    public int commissionOn(int n){
        return ceil(n*20%);
    }

}
