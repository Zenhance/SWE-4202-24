package model;

public class ConcessionItem {
    //String code, String name, double unitPrice.
    private final String code;
    private final String name;
    private final double unitPrice;

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
    //"POP - Popcorn (Large) - BDT 220.00".
    public String toString(){
        return String.format("%s - %s - BDT %f",code,name,unitPrice);
    }
}
