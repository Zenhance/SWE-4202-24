package kenakata.catalog;
import kenakata.order.ColdChain;
import kenakata.order.Insurable;
import kenakata.order.Returnable;
import kenakata.order.Weighable;
import kenakata.settlement.Seller;

public class FreshGood extends CatalogItem Weighable,ColdChain,Insurable,Returnable{
    private final int weightGrams;

    public FreshGood(String sku, String title,long unitPrice,int stock,Seller seller,int weightGrams){
        super(sku,title,unitPrice,stock,seller);
        if(weightGrams<=0){
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.weightGrams=weightGrams;
    }
    @Override
    public long unitVat(){
        return 0;
    }
}
