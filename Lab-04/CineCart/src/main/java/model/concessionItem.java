package model;

public class concessionItem {
    String code;
    String name;
    double unitPrice;

    public concessionItem(String code,String name,double unitPrice){
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

    public String toString(){
        return String.format("%s %s BDT %.2f",code,name,unitPrice);
    }
}
