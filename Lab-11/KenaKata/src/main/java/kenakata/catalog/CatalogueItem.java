package kenakata.catalog;
import kenakata.exceptions.OutOfStockException;

public abstract class CatalogueItem {
    protected String sku;
    protected String title;
    protected long unitPrice;
    protected int stock;
    protected Seller seller;
    public CatalogueItem(String sku,String title,long unitPrice,int stock,Seller seller) {
        if (sku == null || seller == null || title == null)
            throw new IllegalArgumentException();
        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
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
    public int remaining(){
        return stock;
    }
    public Seller seller(){
        return seller;
    }
    public void reserve(int qty) throws OutOfStockException{
        if(qty<=0)
            throw new IllegalArgumentException();
        if(stock<qty)
            throw new OutOfStockException("Not enough stock.");
        stock-=qty;
    }
    public abstract long vatPerUnit();
    public abstract double commissionRate();
}
