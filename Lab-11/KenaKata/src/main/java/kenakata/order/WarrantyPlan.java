import kenakata.catalog.CatalogItem;
import kenakata.order.*;

public abstract class WarrantyPlan implements CatalogItem{
    private String label;
    private double unitCharge;
    private int durationMonths;

    public WarrantyPlan(String label,double unitCharge,int durationMonths){
        this.label=label;
        this.unitCharge=unitCharge;
        this.durationMonths=durationMonths;
    }
}