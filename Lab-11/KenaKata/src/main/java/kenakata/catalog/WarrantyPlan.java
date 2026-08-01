package kenakata.catalog;

public class WarrantyPlan implements Chargeable {
    private CatalogItem coveredItem;
    public WarrantyPlan(CatalogItem coveredItem){
        if(coveredItem==null){
            throw new IllegalArgumentException("Covered item cannot be null");
        }
        this.coveredItem=coveredItem;
    }

    public CatalogItem  coveredItem() {
        return coveredItem;
    }

    @Override
    public long unitCharge(){
        return  (long)Math.ceil(coveredItem.unitCharge()*0.01);
    }

    @Override
    public long unitVat(){
        return (long)Math.ceil(unitCharge()*0.15);
    }

    public String label(){
        return "Warranty for"+coveredItem.title();
    }
}
