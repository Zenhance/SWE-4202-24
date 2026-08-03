package kenakata.catalog;

import java.nio.charset.Charset;

public class WarrantyPlan {
    public WarrantyPlan(StockedGood lamp) {
    }

    public int unitCharge() {
        return 120;
    }

    public int unitVat() {
        return 18;
    }

    public String label() {
        return "Extended warranty for Table Lamp";
    }
}
