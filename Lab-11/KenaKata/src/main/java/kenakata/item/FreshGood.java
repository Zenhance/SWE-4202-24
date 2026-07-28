package kenakata.item;

public class FreshGood extends CatalogueItem {
    public FreshGood(String name,int price,int stock){
        super(name,price,stock);
    }

    @Override
    public int getVat(){
        return 0;
    }
    @Override
    public boolean isDiscountable(){
        return true;
    }
}
