package kenakata.order;

import kenakata.catalog.Chargeable;

public class OrderLine {
    private final Chargeable item;
    private final int quantity;
    private boolean insured;
    private boolean returned;

    public OrderLine(Chargeable item, int quantity) {
        if (item == null || quantity <= 0) {
            throw new IllegalArgumentException("Item cannot be null and quantity must be positive");
        }
        this.item = item;
        this.quantity = quantity;
        this.insured = false;
        this.returned = false;
    }

    public Chargeable item() { return item; }
    public Chargeable chargeable() { return item; }

    public int quantity() { return quantity; }
    public boolean isInsured() { return insured; }
    public void setInsured(boolean insured) { this.insured = insured; }
    public boolean returned() { return returned; }
    public void markReturned() { this.returned = true; }

    public long lineValue() { return item.unitCharge() * quantity; }
    public long lineCharge() { return lineValue(); }

    public long lineVat() { return item.unitVat() * quantity; }
}