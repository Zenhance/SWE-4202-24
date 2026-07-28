package kenakata.catalog;
import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable{
    private final String sku;
    private final String title;
    private final long unitPrice;
    private int stock;
    private final Seller seller;

    protected CatalogItem(String sku, String title, long unitPrice, int stock, Seller seller){
        if(sku == null || sku.isBlank()){
            throw new IllegalArgumentException("SKU must not be blank");
        }
        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("Title must not blank");
        }
        if(unitPrice<0){
            throw new IllegalArgumentException("Unit price cannot be negative");
        }
        if(stock<0){
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        if(seller == null){
            throw new IllegalArgumentException("Seller must not be null");
        }
        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.seller = seller;
    }
    private final String sku(){
        return sku;
    }
    private final String title(){
        return title;
    }
}
