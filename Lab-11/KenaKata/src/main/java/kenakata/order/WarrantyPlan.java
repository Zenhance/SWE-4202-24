import kenakata.catalog.CatalogItem;

public class WarrantyPlan implements CatalogItem{
    private String label;
    private double unitCharge;
    private int durationMonths;

    public WarrantyPlan(String label,double unitCharge,int durationMonths){
        this.label=label;
        this.unitCharge=unitCharge;
        this.durationMonths=durationMonths;
    }
}