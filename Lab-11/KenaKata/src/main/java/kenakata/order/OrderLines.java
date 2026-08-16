package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;

public class OrderLines {
    protected CatalogItem  catalogItem;
    protected int quantity;
    Chargeable chargeable;
    public OrderLines(CatalogItem catalogItem, int quantity) {
        this.catalogItem = catalogItem;
        this.quantity = quantity;
    }
    public OrderLines(Chargeable chargeable) {
        this.chargeable = chargeable;
    }


    public boolean returned() {
        return true;
    }
}
