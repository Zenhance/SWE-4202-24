package kenakata.catalog;



public class WarrantyPlan implements Chargeable{
    private final CatalogItem item;

    public WarrantyPlan( CatalogItem item) {
        this.item = item;
    }

    public CatalogItem getItem() {
        return item;
    }

    @Override
    public long unitVat() {
        return (long) Math.ceil(unitCharge() * 0.15);
    }

    @Override
    public long unitCharge() {
        return (long) Math.ceil(item.unitCharge() * 0.10);
    }



    @Override
    public String label() {
        return "";
    }
}
