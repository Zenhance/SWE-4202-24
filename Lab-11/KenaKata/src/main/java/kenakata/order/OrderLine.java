package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;

public class OrderLine {
    
    private final CatalogItem product;
    private final Chargeable addOn;
    private final int quantity;
    
    private boolean insured;
    private boolean returned;
    
    public OrderLine(CatalogItem product, int quantity) {
        if (product == null)
            throw new IllegalArgumentException();
        if (quantity <= 0)
            throw new IllegalArgumentException();
        
        this.product = product;
        this.addOn = null;
        this.quantity = quantity;
    }
    public OrderLine(Chargeable addOn) {
        if (addOn == null)
            throw new IllegalArgumentException("Add-on cannot be null.");
        
        this.product = null;
        this.addOn = addOn;
        this.quantity = 1;
    }
    
    
    public CatalogItem getProduct() {
        return product;
    }
    
    public Chargeable getAddOn() {
        return addOn;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public boolean isInsured() {
        return insured;
    }
    
    public void insure() {
        insured = true;
    }
    
    public boolean returned() {
        return returned;
    }
    
    public void markReturned() {
        returned = true;
    }
}

