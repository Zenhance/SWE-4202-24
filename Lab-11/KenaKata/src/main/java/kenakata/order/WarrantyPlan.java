package kenakata.order;
import kenakata.catalog.CatalogItem;

public abstract class WarrantyPlan extends CatalogItem{
    private String label;
    private double unitCharge;
    private int durationMonths;

    public WarrantyPlan(String label,double unitCharge,int durationMonths){
        if(unitCharge<0){
            throw new IllegalArgumentException("Unit charge cant be negative");

        }
        if(durationMonths <=0){
            throw new IllegalArgumentException("Duration months must be positive");
        }
        this.label=label;
        this.unitCharge=unitCharge;
        this.durationMonths=durationMonths;
    }

    @Override
    public String label(){
        return this.label;
    }
    @Override
    public double unitCharge(){
        return this.unitCharge;
    }
    public int getDurationMonths(){
        return this.durationMonths;
    }
    public double calculateTotalCost(){
        return unitCharge();
    }
}