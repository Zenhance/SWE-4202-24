package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;
import kenakata.order.Chargeable;
import kenakata.settlement.Seller;

public abstract class CatalogItem implements Chargeable {
    private final String sku;
    private final String title;
    private final long unitPrice;
    private int stock;
    private final Seller seller;
    private String label;
    private double unitCharge;

    public CatalogItem(String sku,String title,long unitPrice, int stock,Seller seller,String label,double unitCharge){
        if(sku == null || sku.isBlank() || title == null || title.isBlank() || seller == null){
            throw new IllegalArgumentException("Invalid catalog item properties");
        }
        this.sku= sku;
        this.title= title;
        this.unitPrice= unitPrice;
        this.stock=stock;
        this.seller=seller;
        this.label= label;
        this.unitCharge=unitCharge;
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
    public double unitCharge(){
        return unitPrice;
    }
    @Override
    public String label(){
        return title;
    }
    public void reserve(int qty)throws OutOfStockException{
        if(qty<=0){
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if( qty > stock){
            throw new OutOfStockException("Not enough stock for item: " + title);
        }
        stock-= qty;

    }
    public abstract long commissionOn(long amount);
}
