package kenakata.catalog;
import kenakata.exceptions.OutOfStockException;
import kenakata.order.Chargeable;

public abstract class CatalogItem implements Chargeable{
    private final String sku;
    private final String title;
    private final long unitPrice;
    private int stock;
    private final Seller seller;
    public CatalogItem(String sku, String title, long unitPrice, int stock, Seller seller){
        if(sku==null || sku.isBlank() || title==null || title.isBlank() || seller==null) {
            throw new IllegalArgumentException("Invalid catalog item properties");
        }
        if(unitPrice<0 || stock<0) {
            throw new IllegalArgumentException("Price and stock cannot be negative");
        }
        this.sku=sku;
        this.title=title;
        this.unitPrice=unitPrice;
        this.stock=stock;
        this.seller=seller;
    }
    public String sku(){
        return sku;
    }
    public String title(){
        return title;
    }
    public Seller seller(){
        return seller;
    }
    public int remaining(){
        return stock;
    }
    @Override
    public long unitCharge(){
        return unitPrice;
    }
    @Override
    public String label(){
        return title;
    }
    public void reserve(int qty) throws OutOfStockException{
        if(qty<=0){
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if(qty>stock){
            throw new OutOfStockException("Not enough stock for item: " + title);
        }
        stock -= qty;
    }
    public abstract long commissionOn(long amount);
}
