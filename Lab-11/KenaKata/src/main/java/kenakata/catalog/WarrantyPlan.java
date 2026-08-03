package kenakata.catalog;

public class WarrantyPlan implements Chargeable {
    private final LineItem lineitem;
    
    public WarrantyPlan(LineItem lineItem) {
        if(lineItem == null){
            throw new IllegalArgumentException("lineItem cannot be null");
        }
        this.lineitem = lineItem;
    }
    
    @Override
    public long unitCharge() {
        return (long)Math.ceil((double)lineitem.unitCharge()*0.1);
    }
    @Override
    public long unitVat(){
        return (long)Math.ceil((double)unitCharge()*.15);
    }
    @Override
    public String label() {
        return "Warranty Plan";
    }
}
