package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;

public final class OrderLine {
    private final Chargeable unit;
    private final int quantity;
    private boolean insured;
    private boolean returned;

    OrderLine(Chargeable unit, int quantity){
        if(unit == null){
            throw new IllegalArgumentException("Order line unit must not be null");
        }
        if(quantity<=0){
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.unit = unit;
        this.quantity = quantity;
    }

}
