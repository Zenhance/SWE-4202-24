package kenakata.catalog;

import java.util.Collection;

public class WarrantyPlan implements Addable {

    StockedGood s;

    public WarrantyPlan(StockedGood s) {
        if(s == null)
            throw new IllegalArgumentException("No Good Found!");
        this.s = s;
    }

    public int unitCharge() {
        double x = Math.ceil(s.unitCharge()*0.1);
        return (int) x;
    }

    public int unitVat() {
        double x = Math.ceil(unitCharge()*0.15);
        return (int) x;
    }

    public String label() {
        return s.getItemType();
    }
}
