package kenakata.catalog;

public class WarrantyPlan implements Chargeable {
    private final CatalogItem item;

    public WarrantyPlan(CatalogItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Warranty item cannot be null");
        }
        this.item = item;
    }

    public long unitCharge() {
        return Math.round(item.unitPrice * 0.10);
    }

    public long unitVat() {
        return Math.round(unitCharge() * 0.15);
    }

    public String label() {
        return "Warranty for " + item.getTitle();
    }
}
