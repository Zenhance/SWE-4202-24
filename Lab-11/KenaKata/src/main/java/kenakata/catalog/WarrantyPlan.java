package kenakata.catalog;

public class WarrantyPlan implements Chargeable{
    private final CatalogItem coveredItem;

    public WarrantyPlan(CatalogItem coveredItem){
        if(coveredItem==null){
            throw new IllegalArgumentException();
        }
        this.coveredItem=coveredItem;
    }

    public String label(){
        return "Warranty for " + coveredItem.name();
    }

    public int unitCharge(){
        return (int) Math.ceil(coveredItem.unitCharge()*10/100.0);
    }

    public int unitVat(){
            return (int) Math.ceil(unitCharge()*15/100.0);
    }
}
