package kenakata.order;
import kenakata.catalog.CatalogItem;

public class WarrantyPlan implements Chargeable{
    private final CatalogItem coveredItem;

    public WarrantyPlan(CatalogItem coveredItem) {
        if (coveredItem == null) {
            throw new IllegalArgumentException("Covered item cannot be null");
        }
        this.coveredItem = coveredItem;
    }
}
