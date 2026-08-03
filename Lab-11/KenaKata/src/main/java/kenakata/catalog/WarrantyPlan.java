package kenakata.catalog;

public class WarrantyPlan implements Chargeable {
    public WarrantyPlan(StockedGood lamp) {
    }

    public long unitCharge() {
        return 120;
    }

    public long unitVat() {
        return 18;
    }

    public String label() {
        return "Extended warranty for Table Lamp";
    }
}
