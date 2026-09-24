package kenakata.catalog;


import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable {

    protected final String sku;
    protected final String title;
    protected final long price;
    protected final int stock;
    protected final Seller seller;



    protected CatalogItem(String sku, String title, long price, int stock, Seller seller){
        this.sku = sku;
        this.title = title;
        this.price = price;
        this.stock=stock;
        this.seller = seller;

    }

    @Override
    public long unitCharge() {
        return price;
    }

    @Override
    public long unitVat() {
        return 0;
    }
    public long commissionOn(long lineValue){
        return 0;
    }
    public int remaining(){
        return stock;
    }
    public Seller seller(){
        return seller;
    }

    public void reserve(int quantity) throws OutOfStockException{

    }

    public String title(){
        return title;
    }

}
