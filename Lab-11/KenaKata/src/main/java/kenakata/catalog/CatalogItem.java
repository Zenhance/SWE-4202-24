package kenakata.catalog;
import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable {
    private final String sku;
    private final String title;
    private final long price;
    private int count;
    private final Seller seller;
    
    public CatalogItem(String sku, String title, long price, int count, Seller seller) {
        if(sku == null || sku.isEmpty() || title == null || title.isEmpty()){
            throw new IllegalArgumentException("sku or title is null or empty");
        }
        requirePositive(count);
        requirePositive(price);
        
        if(seller == null){
            throw new IllegalArgumentException("seller is null");
        }
        
        this.sku = sku;
        this.title = title;
        this.price = price;
        this.count = count;
        this.seller = seller;
    }
    
    public void reserve(int count) throws OutOfStockException {
        requirePositive(count);
        
        if(this.count < count){
            throw new OutOfStockException("Out of stock");
        }
        
        this.count = this.count - count;
    }
    
    public int remaining(){
        return this.count;
    }
    
    public String getSku() {
        return sku;
    }
    public String getTitle() {
        return title;
    }
    public long unitCharge() {
        return price;
    }
    public Seller Seller() {
        return seller;
    }
    
    public abstract long unitVat();
    public abstract double commissionOn(long price);
    
    public void requirePositive(long value){
        if(value <= 0 ){
            throw new IllegalArgumentException("value is negative");
        }
    }

    public final void release(int quantity){
        requirePositive(quantity);
        count = Math.addExact(count, quantity);
    }
}
