package kenakata.catalog;

public class WarrantyPlan implements Chargeable {
    private final CatalogItem item;

    public WarrantyPlan(CatalogItem item) {
        if(item == null) {
            throw new IllegalArgumentException();
        }
        this.item = item;
    }

    @Override
    public long unitCharge() {
        return (long)Math.ceil(
                item.unitCharge() * 10 / 100.0
        );
    }

    @Override
    public long unitVat() {
        return (long)Math.ceil(
                unitCharge() * 15 / 100.0
        );
    }

    @Override
    public String label() {
        return "Warranty for " + item.title();
    }
}