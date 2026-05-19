package model;

public class ConcessionItem {
    private String code;
    private String name;
    private double unitPrice;

    ConcessionItem(String code, String name, double unitPrice){
        this.code = code;
        this.name = name;
        this.unitPrice = unitPrice;
    }
}
