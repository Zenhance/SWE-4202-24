package kenakata.catalog;
import kenakata.exceptions.OutOfStockException;



public abstract class CatalogItem implements Chargeable{
    protected final String sku;
    protected final String title;
    protected final long unitPrice;
    protected  int stock;
    protected final Seller seller;
    public CatalogItem(String sku,String title,long unitPrice,int stock,Seller seller){
        if(sku==null || sku.isBlank()){
            throw new IllegalArgumentException();
        }
        if(title==null || title.isBlank()){
            throw new IllegalArgumentException();
        }
        if(seller==null){
            throw new IllegalArgumentException();
        }
        if(unitPrice<0){
            throw new IllegalArgumentException();
        }
        if(stock<0){
            throw new IllegalArgumentException();
        }
        this.sku=sku;
        this.title=title;
        this.unitPrice=unitPrice;
        this.stock=stock;
        this.seller=seller;
    }

    public String getSku() {
        return sku;
    }

    public long getUnitPrice() {
        return unitPrice;
    }


    public String getTitle() {
        return title;
    }

    @Override
    public long unitCharge() {
        return unitPrice;
    }
    public int remaining(){
        return stock;
    }
    public void reserve(int quantity) throws OutOfStockException{
        if(quantity<=0){
            throw new IllegalArgumentException();
        }
        if(quantity>stock){
            throw new OutOfStockException();
        }
        stock-=quantity;
    }
    public abstract long commissionOn(long value);

    @Override
    public abstract long unitVat();
}
