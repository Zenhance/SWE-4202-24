package kenakata.order;

import kenakata.catalog.Chargeable;

public class OrderLine {
    private final Chargeable unit;
    private final int quantity;
    private boolean returned;

    public OrderLine(Chargeable unit, int quantity) {
        if (unit == null) {
            throw new IllegalArgumentException("Line unit cannot be null.");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        this.unit = unit;
        this.quantity = quantity;
        this.returned = false;
    }

    public boolean isReturned() {
        return false;
    }
}
