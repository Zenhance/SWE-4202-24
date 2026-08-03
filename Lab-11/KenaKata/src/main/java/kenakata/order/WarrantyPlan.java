package kenakata.order;
import kenakata.catalog.CatalogItem;

public class WarrantyPlan implements Chargeable{
    private final CatalogItem coveredItem;

    public WarrantyPlan(CatalogItem coveredItem){
        if (coveredItem == null){
            throw new IllegalArgumentException("Covered item cannot be null");
        }
        this.coveredItem = coveredItem;
    }
    @Override
    public long unitCharge(){
        return (long) Math.ceil(coveredItem.unitCharge() * 0.10);
    }

    @Override
    public long unitVat(){
        return (long) Math.ceil(unitCharge() * 0.15);
    }

    @Override
    public String label(){
        return "Warranty for "+coveredItem.label();
    }
}
