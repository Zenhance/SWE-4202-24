package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable{
    private final String sku;
    private final String title;
    private final long unitPrice;
    private int stock;
    private final Seller seller;

    public CatalogItem(String sku, String title, long unitPrice, int stock, Seller seller ){

        if(sku==null || sku.isBlank()){
            throw new IllegalArgumentException("Invalid SKU");
        }

        if(title==null || title.isBlank()){
            throw new IllegalArgumentException("Invalid title");
        }

        if(seller==null){
            throw new IllegalArgumentException("Seller cannot be null");
        }

        if(unitPrice<0){
            throw new IllegalArgumentException("Price cannot be negative");
        }

        if(stock<0){
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        this.sku=sku;
        this.title=title;
        this.unitPrice=unitPrice;
        this.stock=stock;
        this.seller=seller;
    }

    public String  sku() {
        return sku;
    }

    public String  title() {
        return title;
    }
    public int remaining() {
        return stock;
    }

    public Seller seller() {
        return seller;
    }


    @Override
    public long unitCharge(){
        return unitPrice;  // Every catalogue item will implement their own unit charge. Thats why, we extended them.
    }

    public void reserve(int quantity) throws OutOfStockException {
        if(quantity<=0){
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if(quantity>stock){
            throw  new OutOfStockException("Stock not available");
        }

        stock-=quantity;
    }

    @Override
    public abstract long unitVat();

    public abstract long commissionOn(long lineValue);


}
