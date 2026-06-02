package model;

public class ConcessionItem {
    private String code;
    private String name;
    private double unitPrice;

    public ConcessionItem(String code, String name, double unitPrice){
        this.code = code;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getCode(){
        return code;
    }
    public String getName(){
        return name;
    }
    public double getUnitPrice(){
        return unitPrice;
    }

    public String toString(){
        String ans = String.format("%s - %s - BDT %.2lf", code, name, unitPrice);
        return ans;
    }
}
