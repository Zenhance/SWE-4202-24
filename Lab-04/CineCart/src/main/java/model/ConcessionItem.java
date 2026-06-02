package model;

public class ConcessionItem {
    private String code;
    private String name;
    private double unitPrice;

}
public concessionItem(string code,string name,double unitPrice){
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

double getUnitPrice(){
    return unitPrice;
}
public String toString(){
    return String.format("%s - %s - BDT %.2f",code,name,unitPrice);}
}

