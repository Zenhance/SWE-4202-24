package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;
public class OrderLine{
    private final Chargeable item;
    private final int quantity;
    private boolean insured;
    private boolean returned;
    private int placedDay = -1;
    private int returnedDay = -1;
    public OrderLine(Chargeable item, int quantity){
        if (item == null){
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (quantity <= 0){
            throw new IllegalArgumentException(
                    "Quantity must be positive"
            );
        }
        this.item = item;
        this.quantity = quantity;
    }
    public Chargeable item(){
        return item;
    }
    public int quantity(){
        return quantity;
    }
    public boolean insured(){
        return insured;
    }
    public boolean returned(){
        return returned;
    }
    public void insure(){
        this.insured = true;
    }
    public void markReturned(){
        this.returned = true;
    }
    public int placedDay(){
        return placedDay;
    }
    public void setPlacedDay(int placedDay){
        this.placedDay = placedDay;
    }
    public int returnedDay(){
        return returnedDay;
    }
    public void setReturnedDay(int returnedDay){
        this.returnedDay = returnedDay;
    }
    public long charge(){
        return item.unitCharge() * quantity;
    }
    public long vat(){
        return item.unitVat() * (long) quantity;
    }
    public boolean isProduct(){
        return item instanceof CatalogItem;
    }
    public CatalogItem catalogItem(){
        if (!(item instanceof CatalogItem catalogItem)) {
            return null;
        }
        return catalogItem;
    }
}