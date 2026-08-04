package kenakata.catalog;

public class WarrantyPlan implements Chargeable{
    private final CatalogItem item;
    public WarrantyPlan(CatalogItem item){
        if(item==null){
            throw new IllegalArgumentException("Covered item cannot be null");
        }this.item=item;
    }

    @Override
    public long unitCharge() {
        return (long)Math.ceil(item.unitCharge()*0.10);
    }

    @Override
    public long unitVat() {
        return (long)Math.ceil(unitCharge()*0.15);
    }

    @Override
    public String label() {
        return "Warranty for "+item.title();
    }

}
