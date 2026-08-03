package kenakata.order;

import kenakata.catalog.Chargeable;

public final class OrderLine {

    private final Chargeable item;
    private final int quantity;
    private boolean insured;
    private boolean returned;
    private int placedDay;

    OrderLine(Chargeable item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    public Chargeable item() {
        return item;
    }

    public int quantity() {
        return quantity;
    }

    public boolean insured() {
        return insured;
    }

    public boolean returned() {
        return returned;
    }

    public int placedDay() {
        return placedDay;
    }

    public long lineCharge() {
        return 0;
    }

    public long lineVat() {
        return 0;
    }

    void markInsured() {
        this.insured = true;
    }

    void markReturned() {
        this.returned = true;
    }

    void recordPlacementDay(int today) {
        this.placedDay = today;
    }

}

