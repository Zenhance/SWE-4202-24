package kenakata.catalog;


public class WarrantyPlan implements Chargeable {
    private CatalogItem item;
    public WarrantyPlan(CatalogItem item) {
        this.item=item;
    }

    public long unitCharge() {
        return (long) Math.ceil(item.getUnitPrice()*.1);
    }

    public long unitVat() {
        return (long) Math.ceil( item.getUnitPrice()*.15);
    }

    public String label() {

        return "Warrantly for "+ item.getTitle();
    }
}
