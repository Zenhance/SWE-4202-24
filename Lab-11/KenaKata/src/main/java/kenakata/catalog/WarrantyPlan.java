package kenakata.catalog;

public class WarrantyPlan implements Item {
    private AbstractItem coveredItem;

    public WarrantyPlan(AbstractItem coveredItem) {
        if (coveredItem == null) {
            throw new IllegalArgumentException("Covered item cannot be null");
        }
        this.coveredItem = coveredItem;
    }

    @Override
    public long unitCharge() {
        return (long) Math.ceil(coveredItem.unitPrice() * 0.10);
    }

    @Override
    public long unitVat() {
        return (long) Math.ceil(unitCharge() * 0.15);
    }

    @Override
    public String label() {
        return "Warranty : " + coveredItem.title();
    }
}
