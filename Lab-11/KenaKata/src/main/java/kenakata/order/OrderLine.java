package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;

public class OrderLine {
    private final Chargeable item;
    private final int quantity;
    private boolean insured;
    private boolean returned;
    private int placeDay = -1;
    private int returnDay = -1;
    public OrderLine(Chargeable item, int quantity) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
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

    public long charge() {
        return item.unitCharge() * quantity;
    }

    public long vat() {
        return item.unitVat() * quantity;
    }

    public boolean insured() {
        return insured;
    }

    public boolean returned() {
        return returned;
    }

    public void insure() {
        insured = true;
    }
    public void markPlaced(int day) {
        placeDay = day;
    }
    public int placeDay() {
        return placeDay;
    }
    public int placedDay() {
        return placeDay;
    }
    public void markReturned(int day) {
        returned = true;
        returnDay = day;
    }
    public int returnedDay() {
        return returnDay;
    }
    public boolean isProduct() {
        return item instanceof CatalogItem;
    }
    public CatalogItem catalogItem() {
        if (item instanceof CatalogItem) {
            return (CatalogItem) item;
        }
        return null;
    }
}