import kenakata.catalog.CatalogItem;
package kenakata.order;

public abstract class WarrantyPlan implements CatalogItem{
    private String label;
    private double unitCharge;
    private int durationMonths;

    public WarrantyPlan(String label,double unitCharge,int durationMonths){
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