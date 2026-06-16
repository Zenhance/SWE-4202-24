package model;

public abstract class ComboLine extends LineItem{
    private ConcessionItem a;
    private ConcessionItem b;



    public ComboLine(ConcessionItem a,ConcessionItem b){
        this.a=a;
        this.b=b;
    }



}
