package kenakata.order;

import kenakata.catalog.Chargeable;

public class OrderLine {
    private static final double INSURANCE_RATE_PERCENT=1;
    private static final double INSURANCE_MINIMUM=20;

    private Chargeable item;
    private int quantity;
    private boolean insured;
    private boolean returned;

    OrderLine(Chargeable item, int quantity){
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
    double charge(){
        return item.unitVat()*quantity;
    }
    double vat(){
        return item.unitVat()*quantity;
    }
    double insuranceFee(){
    return 0;
    }
    void markReturned(){
        returned = true;
    }

}

