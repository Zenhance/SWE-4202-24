package kenakata.order;

import kenakata.catalog.Chargeable;

public class OrderLine {
    private Chargeable item;
    private int quantity;
    private boolean insured;
    private boolean returned;

    public OrderLine(Chargeable item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.insured = false;
        this.returned = false;
    }
}
