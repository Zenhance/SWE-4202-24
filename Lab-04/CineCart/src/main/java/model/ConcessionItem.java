package model;

public class ConcessionItem {
    private String name;
    private String code;
    private double unitPrice;

    public ConcessionItem(String name, String code, double unitPrice){
        this.name = name;
        this.code = code;
        this.unitPrice = unitPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }


    public String toString(){
        return String.format("%s - %s - BDT %.2f", code, name, unitPrice);
    }
}
