package kenakata.order;

import kenakata.catalog.*;

public class OrderLine {
    private final Chargeable item;
    private final int quantity;
    private boolean insured;
    private boolean returned;
    public OrderLine(Chargeable item, int quantity) {
        if (item == null) {
            throw new IllegalArgumentException("item cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be positive");
        }
        this.item = item;
        this.quantity = quantity;
    }
    public Chargeable item() {
        return item;
    }
    public int quantity() {
        return quantity;
    }
    public boolean insured() {
        return insured;
    }
    public void insure() {
        insured = true;
    }
    public boolean returned() {
        return returned;
    }
    public void markReturned() {
        returned = true;
    }
    public long charge() {
        return item.unitCharge() * quantity;
    }
    public long vat() {
        return item.unitVat() * quantity;
    }
    public boolean isProduct() {
        return item instanceof CatalogItem;
    }
    public CatalogItem product() {
        return (CatalogItem) item;
    }
}