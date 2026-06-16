package model;

public class ConcessionItem {
    private String code;
    private String name;
    private double unitPrice;

    //constructor
    public ConcessionItem(String code,String name,double unitPrice){
        this.code=code;
        this.name=name;
        this.unitPrice=unitPrice;
    }
    //getters
    public String getCode(){
        return code;
    }
    public String getName(){
        return name;
    }
   public double getUnitPrice(){
        return unitPrice;
   }

}
