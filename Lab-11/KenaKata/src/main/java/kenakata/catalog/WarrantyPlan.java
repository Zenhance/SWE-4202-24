package kenakata.catalog;



public class WarrantyPlan implements Chargeable{

    public WarrantyPlan(StockedGood lamp) {
    }

    @Override
    public long unitVat() {
        return 0;
    }

    @Override
    public long unitCharge() {
        return 0;
    }

    @Override
    public String label() {
        return "";
    }
}
