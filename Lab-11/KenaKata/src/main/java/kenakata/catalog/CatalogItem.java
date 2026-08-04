package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;
import kenakata.order.Chargeable;

public abstract class CatalogItem implements Chargeable { //implementing chargeable allows Order
                                                          // class to process all elements through a unified interface
    private final String sku; //product identifier code
    private final String title;
    private final long unitPrice; //price of one unit
    private int stock; //number of items available
    private final Seller seller; //merchant who owns and sells
    private String label; //display name of the item
    private double unitCharge; // base price of one single item

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
    public void reserve(int qty)throws OutOfStockException{ //decrements the product's stock when a customer places an order
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
//abstract method forces every child class to supply its own calculation of commission