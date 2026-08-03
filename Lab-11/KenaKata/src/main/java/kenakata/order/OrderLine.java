package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;

public final class OrderLine {
    private final Chargeable unit;
    private final int quantity;
    private boolean insured;
    private boolean returned;

    OrderLine(Chargeable unit, int quantity){
        if(unit == null){
            throw new IllegalArgumentException("Order line unit must not be null");
        }
        if(quantity<=0){
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.unit = unit;
        this.quantity = quantity;
    }
    public Chargeable unit(){
        return unit;
    }
    public int quantity(){
        return quantity;
    }
    public long lineValue(){
        return Math.multiplyExact(unit.unitCharge(),quantity);
    }
    public long lineVat(){
        return Math.multiplyExact(unit.unitVat(),quantity);
    }
    public boolean insured(){
        return insured;
    }
    void markInsured(){
        insured=true;
    }
    public boolean returned(){
        return returned;
    }
    void markReturned(){
        returned = true;
    }
    public boolean isProduct(){
        return unit instanceof CatalogItem;
    }
    public CatalogItem product(){
        if(!(unit instanceof CatalogItem item)){
            throw new IllegalArgumentException("This line is not a product");
        }
        return item;
    }
}
