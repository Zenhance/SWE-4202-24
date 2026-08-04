package kenakata.catalog;

import kenakata.order.Chargeable;

public class GiftWrap implements Chargeable {
    @Override
    public double unitCharge(){
        return 50;
    }
    @Override
    public long unitVat(){

        return (long) Math.ceil(50*0.075);
    }
    @Override
    public String label(){

        return "Gift Wrapping";
    }
}
