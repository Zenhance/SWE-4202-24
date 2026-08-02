package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;

public class Line {
    CatalogItem item;
    Chargeable charge;
    int quantity;
    public Line(CatalogItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    public Line(Chargeable charge) {
        this.charge= charge;
    }
    public boolean returned() {return true;}
}
