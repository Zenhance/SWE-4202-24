package kenakata.order;

import kenakata.catalog.Chargeable;
import kenakata.catalog.FreshGood;
import kenakata.catalog.StockedGood;

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

    public long subtotal(){
        return item.unitCharge()*quantity;
    }

    public long vat(){
        return item.unitVat()*quantity;
    }

    public void insure(){
        insured=true;
    }

    public void returnItem(){
        returned=true;
    }

    public long insuranceFee(){
        if(!insured){
            return 0;
        }
        long value=0;
        if(item instanceof StockedGood){
            StockedGood stocked = (StockedGood) item;
            value=stocked.insure(quantity);
        }
        else if(item instanceof FreshGood fresh){
            value=fresh.insure(quantity);
        }
        else{
            return 0;
        }
        long fee=(long)Math.ceil(value*0.01);

        return Math.max(fee,20);

    }



}
