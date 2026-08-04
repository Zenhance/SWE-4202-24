package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.exceptions.OutOfStockException;

public class OrderLine {
    public final CatalogItem item;
    public final int qty;
    public boolean insured = false;
    public boolean returned = false;
    public int placedDay = 0;

    OrderLine(CatalogItem item, int qty) throws OutOfStockException {
        if(qty <= 0)  throw new OutOfStockException("Qty must be greater than 0");
        this.item = item;
        this.qty = qty;
    }

    public boolean returned() {
        return returned;
    }
}
