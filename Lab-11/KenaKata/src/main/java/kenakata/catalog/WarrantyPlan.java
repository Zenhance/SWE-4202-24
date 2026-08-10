package kenakata.catalog;

public class WarrantyPlan implements Chargeable {
    private final CatalogItem item;
    public WarrantyPlan(CatalogItem item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        this.item = item;
    }
    public long unitCharge() {
        return (long) Math.ceil(item.unitCharge() * 0.10);
    }
    public long unitVat() {
        return (long) Math.ceil(unitCharge() * 0.15);
    }
    public long commissionOn(long value) {
        return 0;
    }
    public String label() {
        return "Warranty for " + item.title();
    }
}