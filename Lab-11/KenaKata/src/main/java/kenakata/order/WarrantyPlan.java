package kenakata.order;

import kenakata.catalog.Chargeable;

public class WarrantyPlan implements Chargeable {
    private static final double CHARGE_RATE_PERCENT = 10;
    private static final double VAT_RATE_PERCENT = 15;

    private Chargeable coveredItem;

    public double unitCharge(){
        return (double)Math.ceil(coveredItem.unitCharge()*CHARGE_RATE_PERCENT/100.0);
    }
    public double unitVat(){
        return (double) Math.ceil(unitCharge() *VAT_RATE_PERCENT/100.0);
    }
    public String label(){
        return "Extended warranty for"+coveredItem.label();
    }

}
