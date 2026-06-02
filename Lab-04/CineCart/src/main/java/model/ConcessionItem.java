package model;

public class ConcessionItem {

    //fields
    String code;
    String name;
    double unitPrice;

    //constructor
    public String toString(){
        String str = code + " - " + name + " - BDT " + unitPrice;

        return str;
    }



}