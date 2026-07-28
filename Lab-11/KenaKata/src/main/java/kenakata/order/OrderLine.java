package kenakata.order;

import kenakata.payment.Chargeable;

public class OrderLine {

    private final Chargeable item;
    private final int quantity;
    private boolean returned;

    public OrderLine(Chargeable item, int quantity) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }

        this.item = item;
        this.quantity = quantity;
        this.returned = false;
    }

    public Chargeable item() {
        return item;
    }

    public int quantity() {
        return quantity;
    }

    public boolean returned() {
        return returned;
    }

    public void markReturned() {
        this.returned = true;
    }
}