package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public class FreshGood extends CatalogItem implements Weighable,Returnable,Insurable{
    private int stock;
    private final int weight;

    public FreshGood(String sku,String name,int price,int stock,Seller seller,int weight){
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

    public void reserve(int quantity)throws OutOfStockException {
        if(quantity<=0){
            throw new IllegalArgumentException();
        }
        if(quantity>stock){
            throw new OutOfStockException();
        }
        stock-=quantity;
    }

    public int unitVat(){
        return 0;
    }

    public int commissionOn(int amount){
        return (int) Math.ceil(amount*5/100.0);
    }

    public int weightGrams(){
        return weight;
    }

    public int returnWindowDays(){
        return 2;
    }

    public int remaining(){
        return stock;
    }
}
