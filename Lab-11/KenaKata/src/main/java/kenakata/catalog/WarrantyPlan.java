package kenakata.catalog;

import javax.naming.directory.Attribute;

public class WarrantyPlan extends AddOn {

    public WarrantyPlan(StockedGood lamp) {
        super();
    }

    public String label() {
    return "WarrantyPlan";}

    @Override
    public long unitCharge() {
        return 0;
    }

    @Override
    public long unitVat() {
        return 0;
    }
}
