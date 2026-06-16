package model;

public class ComboLine extends LineItem {
    private ConcessionItem a;
    private ConcessionItem b;

    public ComboLine(ConcessionItem a, ConcessionItem b) {
        this.a=a;
        this.b=b;
    }

    public double subtotal(){
        return 0.0;
    }

    public String describe(){
        return null;
    }
}
