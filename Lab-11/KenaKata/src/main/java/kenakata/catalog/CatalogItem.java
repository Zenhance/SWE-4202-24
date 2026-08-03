package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable {
    private final String sku;
    private final String title;
    private final long unitPrice;
    private int stock;
    private final Seller seller;

    public CatalogItem(String sku, String title, long unitPrice, int stock, Seller seller) {
        if(sku == null || sku.isBlank()){
            throw new IllegalArgumentException("SKU can't be blank");
        }
        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("title can't be blank");
        }
        if(unitPrice<0){
            throw new IllegalArgumentException("price can't be negative");
        }
        if(stock<0){
            throw new IllegalArgumentException("Stock can't be negative");
        }
        if(seller == null){
            throw new IllegalArgumentException("Seller can't be null");
        }
    this.sku = sku;
        this.title = title;
        this.unitPrice=unitPrice;
        this.stock = stock;
        this.seller = seller;
    }

    public String sku(){
        return sku;
    }
    public String title(){
        return title;
    }

    public long unitPrice(){
        return unitPrice;
    }
    public Seller seller(){
        return seller;
    }
    public int remaining(){
        return stock;
    }

    @Override
    public long unitCharge() {
        return unitPrice;
    }

    public void reserve(int quantity) throws OutOfStockException{

        if(quantity<0){
            throw new IllegalArgumentException("Quantity must be positive");
        }

        if(quantity > stock){
            throw new OutOfStockException();
        }
        stock -= quantity;
    }

    public abstract long commissionOn (long lineValue);

}