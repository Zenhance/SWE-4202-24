package kenakata.order;

import kenakata.catalog.Chargeable;

public class OrderLine {
    private final Chargeable unit;
    private final int quantity;
    private boolean returned;

    public OrderLine(Chargeable unit, int quantity) {
        this.unit = unit;
        this.quantity = quantity;
        this.returned = false;
    }

    public boolean isReturned() {
        return false;
    }
}
