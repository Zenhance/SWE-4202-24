package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;

public class WarrantyPlan implements Chargeable{
    private final CatalogItem item;

    public WarrantyPlan(CatalogItem item) {
        if(item == null) throw new IllegalArgumentException();
        this.item=item;
    }

    @Override
    public long unitCharge() {
        return 0;
    }

    @Override
    public long unitVat() {
        return 0;
    }

    @Override
    public String label() {
        return "";
    }
}
