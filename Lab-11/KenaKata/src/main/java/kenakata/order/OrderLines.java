package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;

public class OrderLines {
    protected int quantity;
    Chargeable item;
    protected boolean insured = false;
    protected boolean placed = false;
    public OrderLines(Chargeable item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    public OrderLines(Chargeable item) {
        this.item = item;
        this.quantity = 1;
    }


    public boolean returned() {
        return true;
    }
}
