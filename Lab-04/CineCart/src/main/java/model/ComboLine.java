package model;

public class ComboLine extends LineItem{
    ConcessionItem a;
    ConcessionItem b;
    public ComboLine(ConcessionItem a, ConcessionItem b){
        this.a = a;
        this.b = b;
    }
}
