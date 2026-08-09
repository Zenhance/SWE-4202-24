package kenakata.order;

import kenakata.catalog.CatalogItem;

public class WarrantyPlan implements Chargeable {

    private final CatalogItem coveredItem;

    public WarrantyPlan(CatalogItem coveredItem) {
        if (coveredItem == null) {
            throw new IllegalArgumentException();
        }

        this.coveredItem = coveredItem;
    }

    @Override
    public long unitCharge() {
        return (coveredItem.unitPrice() * 10 + 99) / 100;
    }

    @Override
    public long unitVat() {
        return (unitCharge() * 15 + 99) / 100;
    }

    @Override
    public String label() {
        return "Warranty for " + coveredItem.title();
    }

    public CatalogItem coveredItem() {
        return coveredItem;
    }
}