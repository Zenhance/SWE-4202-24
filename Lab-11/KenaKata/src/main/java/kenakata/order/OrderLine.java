package kenakata.order;

import kenakata.catalog.*;

public class OrderLine {

    private Chargeable item;
    private int quantity;
    private boolean insured;
    private boolean returned;

    public OrderLine(Chargeable item , int quantity) {
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
}
