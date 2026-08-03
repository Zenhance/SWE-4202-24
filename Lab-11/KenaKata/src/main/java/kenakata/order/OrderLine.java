package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;

public class OrderLine {
    public OrderLine(CatalogItem item, int quantity) {
    }

    public OrderLine(Chargeable addOn, int quantity) {
    }

    public void markReturned() {
    }

    public Object unit() {
        return null;
    }

    public String label() {
        return "";
    }

    public boolean returned() {
        return false;
    }

    public void markInsured() {
    }

    public Integer quantity() {
        return 0;
    }

    public boolean insured() {
        return false;
    }

    public long vat() {
        return 0;
    }

    public long charge() {
        return 0;
    }
}
