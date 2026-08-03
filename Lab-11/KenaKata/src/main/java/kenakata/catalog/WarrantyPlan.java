package kenakata.catalog;

public class WarrantyPlan implements Chargeable {
    private CatalogItem item;
    public WarrantyPlan(CatalogItem item) {
        if(item == null) {
            throw new IllegalArgumentException("Invalid item");
        }
        this.item = item;
    }
    @Override
    public long unitCharge() {
        return (item.unitCharge() * 10) / 100;
    }
    @Override
    public long unitVat() {
        return (unitCharge() * 15) / 100;
    }
    @Override
    public String label() {
        return "Warranty for " + item.name();
    }
}