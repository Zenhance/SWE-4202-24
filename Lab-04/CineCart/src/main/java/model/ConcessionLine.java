package model;

public class ConcessionLine extends LineItem{
    private String name;
    private double unitPrice;
    private int qty;
    public ConcessionLine(String name,double unitPrice,int qty){
        this.name=name;
        this.unitPrice=unitPrice;
        this.qty=qty;
    }


}
