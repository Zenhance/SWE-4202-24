package kenakata.order;

import kenakata.catalog.CatalogItem;

public class OrderLine {
    private final CatalogItem product;
    private final int quantity;
    private boolean returned;

    public OrderLine(CatalogItem product, int quantity ){
        if(product==null){
            throw new IllegalArgumentException("Product cannot be null");
        }
        if(quantity<0){
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.product=product;
        this.quantity=quantity;
    }

    public CatalogItem product() {
        return product;
    }

    public int quantity() {
        return quantity;
    }

    public boolean returned() {
        return returned;
    }

    public void markReturned(){
        returned= true;
    }
}
