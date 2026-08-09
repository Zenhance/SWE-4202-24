package kenakata.order;

import kenakata.catalog.CatalogItem;

public class Line {
    private CatalogItem catalogItem;
    private int quantity;
    private boolean returned;
    public boolean insured;

    public Line(CatalogItem catalogItem, int quantity) {
        this.catalogItem = catalogItem;
        this.quantity = quantity;
    }

    public boolean isReturned() {
        return returned;
    }

    public boolean isInsured() {
      return insured;
    }
}