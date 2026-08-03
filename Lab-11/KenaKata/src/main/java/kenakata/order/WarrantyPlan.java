package kenakata.order;
import kenakata.catalog.CatalogItem;

public abstract class WarrantyPlan implements Chargeable{
    private final String label;
    private final double unitCharge;
    private final int durationMonths;

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

    @Override
    public long unitVat() {
        return (long) Math.ceil(unitCharge * 0.075);
    }

}