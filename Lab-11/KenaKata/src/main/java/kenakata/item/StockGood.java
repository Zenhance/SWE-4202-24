package kenakata.item;

public class StockGood extends CatalogueItem{
    public StockGood(String name,int price,int stock){
        super(name,price,stock);
    }
    @Override
    public int getVat(){
        return (int) Math.ceil(price*0.05);
    }
    @Override
    public boolean isDiscountable(){
        return true;
    }
}
