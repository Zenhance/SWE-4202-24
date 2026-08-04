package kenakata.catalog;

public class WarrentyPlan implements Chargeable {
    private CatalogItem coveredItem;
    public WarrentyPlan(CatalogItem coveredItem){
        if(coveredItem==null){
            throw new IllegalArgumentException("Covered item can not be null!");
        } this.coveredItem=coveredItem;}
    public CatalogItem coveredItem(){
        return coveredItem;

    }
    public long unitCharge(){
        return (long)Math.ceil(coveredItem.unitCharge()*0.01);
    }
public long unitVat(){
    return (long)Math.ceil(unitCharge()*0.15);}
public String label(){
    return "Warrenty for "+coveredItem.getName();
}
}
