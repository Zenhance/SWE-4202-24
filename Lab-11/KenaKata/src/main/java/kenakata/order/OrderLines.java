package kenakata.order;

import kenakata.catalog.CatalogItem;

public class OrderLines {
    private CatalogItem  catalogItem;
    private double amount;
    public OrderLines(CatalogItem catalogItem, double amount) {
        this.catalogItem = catalogItem;
        this.amount = amount;
    }


    public boolean returned() {
        return true;
    }
}
