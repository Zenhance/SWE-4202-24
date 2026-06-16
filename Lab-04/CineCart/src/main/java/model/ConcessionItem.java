package model;

public class ConcessionItem {
    private String code;
    private String name;
    private double unitPrice;


public ConcessionItem(String code, String name, double unitPrice){

    this.code=code;
    this.name=name;
    this.unitPrice=unitPrice;
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

public String toString(){  //"POP - Popcorn (Large) - BDT 220.00".

    String res=String.format("POP - %s (%d) - BDT %.2f",name,code,unitPrice);

    return res;

} }

// CLass animal {
