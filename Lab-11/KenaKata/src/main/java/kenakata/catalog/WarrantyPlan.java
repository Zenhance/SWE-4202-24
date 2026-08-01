package kenakata.catalog;

public class WarrantyPlan implements Chargeable{

    protected CatalogItem catalog;
    public WarrantyPlan(CatalogItem catalog) {
        this.catalog=catalog;
    }

    @Override
    public long unitCharge() {
        return (long)Math.ceil(catalog.unitCharge()* 0.1);
    }

    @Override
    public long unitVat() {
        return (long) Math.ceil(unitCharge()*0.15);
    }

    public String label(){
        return catalog.title;
    }
}
