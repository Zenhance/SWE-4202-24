package kenakata.catalog;

public class WarrantyPlan implements Item {
    private AbstractItem coveredItem;

    public WarrantyPlan(AbstractItem coveredItem) {
        if (coveredItem == null) {
            throw new IllegalArgumentException("Covered item cannot be null");
        }
        this.coveredItem = coveredItem;
    }
}
