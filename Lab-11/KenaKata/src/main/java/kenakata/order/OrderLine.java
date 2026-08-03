package kenakata.order;

import kenakata.catalog.Chargeable;

public class OrderLine {
    private Chargeable item;
    private int quantity;
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
}
