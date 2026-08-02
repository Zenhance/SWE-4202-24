package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;

public class OrderLine {
    private final Chargeable item;
    private final int quantity;
    private boolean insured = false;
    private boolean returned =false;

    public OrderLine(Chargeable item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}
