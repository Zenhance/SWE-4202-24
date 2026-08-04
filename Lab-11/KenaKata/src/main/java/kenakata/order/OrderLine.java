package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;

public class OrderLine {
    private final Chargeable unit;
    private final CatalogItem item;
    private final int quantity;
    private boolean insured;
    private boolean returned;
    public OrderLine(Chargeable unit, CatalogItem item, int quantity) {
        this.item = item;
        if(quantity <= 0) {throw new IllegalArgumentException("quantity must be positive");}
        this.unit = unit;
        this.quantity = quantity;
    }

    public Chargeable unit() {return unit;}
    public int quantity() {return quantity;}
    public boolean returned() { return returned; }

    public boolean insured() { return insured; }
    public long lineCharge() { return unit.unitCharge() * quantity; }
    public long lineVat() { return unit.unitVat() * quantity; }




}
