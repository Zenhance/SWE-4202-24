package kenakata.catalog;
import kenakata.exceptions.OutOfStockException;

public class StockedGood extends CatalogItem implements Discountable, Weighable,Insurable,Returnable {
    private int stock;
    private final int weight;

    public StockedGood(String sku,String name,int price,int stock,Seller seller,int weight){
        super(sku,name,price,seller);
        if(stock<0){
            throw new IllegalArgumentException();
        }
        if(weight<=0){
            throw new IllegalArgumentException();
        }
        this.stock=stock;
        this.weight=weight;
    }

    public int stock(){
        return stock;
    }
    public int weight(){
        return weight;
    }

    public int unitVat(){
        return ceilPercent(unitCharge(),7.5);
    }

    public int commissionOn(int amount){
        return(int) Math.ceil(amount*8/100.0);
    }

    public int weightGrams(){
        return weight;
    }

    public int returnWindowDays(){
        return 7;
    }

    public void reserve(int quantity) throws OutOfStockException{
        if(quantity<=0){
            throw new IllegalArgumentException();
        }
        if (quantity>stock){
            throw new OutOfStockException();
        }
        stock-=quantity;
    }

    public int remaining(){
        return stock;
    }
}

