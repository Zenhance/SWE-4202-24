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

    public String toString(){
        String string = String.format("%s - %s - BDT %d.00",code,name,unitPrice);
        return string;
    }
}
