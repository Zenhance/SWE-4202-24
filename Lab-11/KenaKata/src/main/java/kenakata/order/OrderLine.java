package kenakata.order;

import kenakata.catalog.Chargeable;

public class OrderLine {
    private final Chargeable item;
    private final int unit;
    private  boolean insured;
    private  boolean returned;

    public OrderLine(Chargeable item, int unit) {
        this.item = item;
        this.unit = unit;
        this.insured = false;
        this.returned = false;
    }

    public Chargeable getItem() {
        return item;
    }

    public int getUnit() {
        return unit;
    }

    public boolean isInsured() {
        return insured;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }
}
