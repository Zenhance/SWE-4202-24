package model;

public class ConcessionItem {
    private String code;
    private String name;
    private double unitPrice;
    public ConcessionItem(String code, String name,double unitPrice){
        this.code = code;
        this.name = name;
        this.unitPrice = unitPrice;
    }
    public String getCode(){
        return this.code;
    }
    public String getName(){
        return this.name;
    }
    public double getUnitPrice(){
        return this.unitPrice;
    }
    public String toString(){
        return code+" - "+name+" (Large) - BDT"+unitPrice;
    }
}
