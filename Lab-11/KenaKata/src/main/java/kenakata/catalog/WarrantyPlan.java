package kenakata.catalog;

import java.awt.*;

public class WarrantyPlan implements Chargeable {
    private StockedGood stockedGood;
    public WarrantyPlan(StockedGood good) {
        this.stockedGood = good;
    }

    public int unitCharge() {
        return 0;
    }

    public int unitVat() {
        return 0;
    }

    public String label() {
        return "Table";
    }
}
