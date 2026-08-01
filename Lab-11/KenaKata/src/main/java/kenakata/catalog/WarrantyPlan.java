package kenakata.catalog;

public final class WarrantyPlan implements Chargeable{
    private final CatalogItem coveredItem;
    private final long charge;

    public WarrantyPlan(CatalogItem coveredItem){
        if(coveredItem == null){
            throw new IllegalArgumentException("Covered item must not be null");
        }
        this.coveredItem = coveredItem;
        this.charge = MoneyMath.ceilPercent(coveredItem.unitPrice(),10);
    }
    public CatalogItem coveredItem(){
        return coveredItem;
    }

    @Override
    public long unitCharge(){
        return charge;
    }
    @Override
    public long unitVat(){
        return MoneyMath.ceilPercent(charge,15);
    }
    @Override
    public String label(){
        return "Extended warranty for "+coveredItem.title();
    }
}
