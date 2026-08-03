package kenakata.catalog;

public class WarrantyPlan extends AddOn {
    private final CatalogItem item;

    public WarrantyPlan(CatalogItem item) {
        if(item == null){
            throw new IllegalArgumentException("Covered item required");
        }
        this.item=item;
    }

    @Override
    public long unitCharge(){
        return (item.unitCharge()*10)/100;
    }

    @Override
    public long unitVat(){
        \return (unitCharge()*15 + 99)/100;
    }

    @Override
    public String label(){
        return "Warranty for " + item.title();
    }

}