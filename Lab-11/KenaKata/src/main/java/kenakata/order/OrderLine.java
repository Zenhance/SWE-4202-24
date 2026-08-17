package kenakata.order;

import kenakata.catalog.Chargeable;

public class OrderLine {

    private final Chargeable item;
    private final int quantity;
    private boolean insured;
    private boolean returned;

    public OrderLine(Chargeable item, int quantity) {
        if (item == null) {
            throw new IllegalArgumentException("item must not be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be positive");
        }
        this.item = item;
        this.quantity = quantity;
    }

    public Chargeable item() {
        return item;
    }

    public int quantity() {
        return quantity;
    }

    public long value() {
        return item.unitCharge() * quantity;
    }

    public long vatTotal() {
        return item.unitVat() * quantity;
    }

    public boolean insured() {
        return insured;
    }

    void markInsured() {
        insured = true;
    }

    public boolean returned() {
        return returned;
    }

    void markReturned() {
        returned = true;
    }
}