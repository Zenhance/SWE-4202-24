package kenakata.catalog;

public class WarrantyPlan implements Chargeable{
    protected CatalogItem catalogItem;
    WarrantyPlan(CatalogItem catalogItem){
        if(catalogItem== null)throw new IllegalArgumentException("Catalog item cant be null");
        this.catalogItem=catalogItem;
    }
    @Override
    public long unitCharge() {
        return (long) Math.ceil(catalogItem.unitCharge()*0.1);
    }

    @Override
    public long unitVat() {
        return (long) Math.ceil(unitCharge() * 0.15);
    }
    public String label(){
        return catalogItem.title;
    }
}
