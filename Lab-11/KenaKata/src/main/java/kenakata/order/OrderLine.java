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

