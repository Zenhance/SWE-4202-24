package kenakata.order;

import kenakata.catalog.*;

public class OrderLine {

    private Chargeable item;
    private int quantity;
    private boolean insured;
    private boolean returned;

    public OrderLine(Chargeable item , int quantity) {
        if(item==null){
            throw new IllegalArgumentException("item is null ");
        }
        if(quantity<=0){
            throw new IllegalArgumentException("quantity is negative or zero");
        }
        this.quantity=quantity;
        this.item=item;
        returned=false;
    }

    public boolean returned(){
        returned=true;
        return returned;
    }
    public boolean isReturned(){
        return returned;
    }

    public Chargeable getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}
