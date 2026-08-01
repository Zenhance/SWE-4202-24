package kenakata.catalog;

public final class WarrantyPlan implements Chargeable{
    private final CatalogItem coveredItem;
    private final long charge;

    public WarrantyPlan(CatalogItem covereItem){
        if(coveredItem == null){
            throw new IllegalArgumentException("Covered item must not be null");
        }
        this.coveredItem = coveredItem;
        this.charge = MoneyMath.ceilPercent(coveredItem.unitPrice(),10);
    }
}
