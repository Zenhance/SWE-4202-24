package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable{
    protected String sku;
    protected String title;
    protected int unitPrice;
    protected int stockCount;
    protected Seller seller;


    public String sku() {
        return sku;
    }

    public String title() {
        return title;
    }
   public Seller seller(){
        return seller;
   }
    public int unitPrice() {
        return unitPrice;
    }

    public int stockCount() {
        return stockCount;
    }

    public CatalogItem(String sku, String title, int unitPrice, int stockCount){
        if(sku==null||title==null||title.isBlank()){
            throw new IllegalArgumentException("SKU and title cannot be blank");
            if(unitPrice<0){
                throw new IllegalArgumentException("Unit Price can not be negative");
            }
            if(stockCount<0){
                throw new IllegalArgumentException("Stock can't be negative");
            }
            if(seller==null){
                throw new IllegalArgumentException("Seller can't be null");
            }
        }

        this.sku=sku;
        this.title=title;
        this.unitPrice=unitPrice;
        this.stockCount=stockCount;
    }
    public synchronized void reserve(int quantity)throws OutOfStockException{
        if(quantity<=0){
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if(quantity>stockCount){
            throw new OutOfStockException("Insufficient stock for "+title);
        }
        stockCount-=quantity;
    }

public abstract boolean isDiscountable();
    public abstract boolean isWeighable();
    public abstract int weightGrams();
    public abstract boolean needsColdChain();
    public abstract boolean isInsurable();
    public abstract boolean isReturnable();
    public abstract int returnWindowDays();
    public abstract long commissionOn(long lineValue);

}
