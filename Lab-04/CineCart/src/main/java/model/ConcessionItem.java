package model;

public class ConcessionItem {

    //fields
    String code;
    String name;
    double unitPrice;

    //constructor
    public ConcessionItem(String code, String name, double unitPrice){
        this.code = code;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String toString(){
        String str = code + " - " + name + " - BDT " + unitPrice;

        return str;
    }



}