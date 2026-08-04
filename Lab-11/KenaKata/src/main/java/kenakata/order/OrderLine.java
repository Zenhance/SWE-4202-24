package kenakata.order;

import kenakata.catalog.Chargeable;

public final class OrderLine {

    private final Chargeable chargeable;
    private final int quantity;
    private boolean insured;
    private boolean returned;

    public OrderLine(Chargeable chargeable, int quantity) {
        if (chargeable == null) {
            throw new IllegalArgumentException("chargeable must not be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be positive");
        }
        this.chargeable = chargeable;
        this.quantity = quantity;
    }

    public Chargeable chargeable() {
        return chargeable;
    }

    public int quantity() {
        return quantity;
    }

    public boolean insured() {
        return insured;
    }

    void markInsured() {
        this.insured = true;
    }

    public boolean returned() {
        return returned;
    }

    void markReturned() {
        this.returned = true;
    }

    public long lineCharge() {
        return chargeable.unitCharge() * quantity;
    }

    public long lineVat() {
        return chargeable.unitVat() * quantity;
    }
}
