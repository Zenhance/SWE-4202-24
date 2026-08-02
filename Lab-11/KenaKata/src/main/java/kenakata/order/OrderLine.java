package kenakata.order;

import kenakata.catalog.Chargeable;

public class OrderLine {
    private Chargeable item;
    private int quantity;
    public OrderLine(Chargeable item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    private boolean insured,returned;

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

}
