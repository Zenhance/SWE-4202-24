package kenakata.catalog;

import javax.naming.directory.Attribute;

public class WarrantyPlan extends AddOn {

    public CatalogItem item;
    public WarrantyPlan(CatalogItem item) {
        this.item=item;
    }

    public String label() {
    return "WarrantyPlan";}

    @Override
    public long unitCharge() {
        return (long) (item.UnitePrize*0.01);
    }

    @Override
    public long unitVat() {
        return 0;
    }
}
