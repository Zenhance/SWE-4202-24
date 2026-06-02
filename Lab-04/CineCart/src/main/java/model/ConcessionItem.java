package model;

public class ConcessionItem {
    String code;
    String name;
    double unitPrice;
    ConcessionItem(String code, String name, double unitPrice){
        this.code=code;
        this.name=name;
        this.unitPrice=unitPrice;
    }
    public String getCode(){
        return code;
    }
    String getName(){
        return name;
    }
    double getUnitPrice(){
        return unitPrice;
    }
    public String toString(){
        return String.format("%s - %s - BDT .2f", code,name,unitPrice);
    }
}
