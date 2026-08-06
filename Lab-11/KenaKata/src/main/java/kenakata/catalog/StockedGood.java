package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

import static java.lang.Math.ceil;

public class StockedGood extends CatalogItem{
    int weight,stock;
    public StockedGood(String SKU, String title, int unitprice, int stock, Seller s1, int Weight){
        super(SKU,title,unitprice,s1);
        if(Weight<=0) throw new IllegalArgumentException();
        if(stock<0) throw new IllegalArgumentException();

        this.weight = Weight;
        this.stock = stock;
    }



    public void reserve(int amount) throws OutOfStockException {
         {
            if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
            if (stock >= amount) stock -= amount;
            else {
                throw new OutOfStockException();
            }
        }
//        catch (OutOfStockException | IllegalArgumentException e) {
//            stock = stock;
//        }
    }
    public int remaining() {
        return stock;
    }

    @Override
    public int unitVat() {
        return (int) ceil(unitprice*0.075);
    }
    @Override
    public int commissionOn(int total) {
        return (int) ceil(total*0.08);
    }
}
