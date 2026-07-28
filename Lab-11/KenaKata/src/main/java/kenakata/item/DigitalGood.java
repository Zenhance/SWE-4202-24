package kenakata.item;

public class DigitalGood extends CatalogueItem{
    public DigitalGood(String name,int price){
        super(name,price,Integer.MAX_VALUE);
    }

    @Override
    public int getVat(){
        return (int) Math.ceil(price*0.15);
    }
    @Override
    public boolean isDiscountable(){
        return false;
    }
}
