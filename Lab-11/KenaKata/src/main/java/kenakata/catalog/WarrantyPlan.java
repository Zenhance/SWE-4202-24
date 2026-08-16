package kenakata.catalog;

import java.awt.*;

public class WarrantyPlan implements Chargeable {
    private StockedGood stockedGood;
    public WarrantyPlan(StockedGood good) {
        if(stockedGood == null) {
            throw new IllegalArgumentException("stockedGood cannot be null");
        }
        this.stockedGood = good;
    }

    public long unitCharge() {
        return (long) Math.ceil(stockedGood.unitCharge() * 0.1);
    }

    public long unitVat() {
        return (long) Math.ceil(unitCharge() * 0.15);
    }

    public String label() {
        return "Table Lamp";
    }
}
