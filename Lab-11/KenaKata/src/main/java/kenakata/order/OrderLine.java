package kenakata.order;

import kenakata.catalog.Chargeable;

public class OrderLine {
    private Chargeable item;
    private int quantity;
    private boolean insured;
    private boolean returned;
    public OrderLine(Chargeable item, int quantity) {
        if(item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if(quantity <= 0) {
            throw new IllegalArgumentException("Invalid quantity");
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
    public boolean insured() {
        return insured;
    }
    public void makeInsured() {
        insured = true;
    }
    public boolean returned() {
        return returned;
    }
    public void makeReturned() {
        returned = true;
    }
    public long value() {
        return item.unitCharge() * quantity;
    }
}