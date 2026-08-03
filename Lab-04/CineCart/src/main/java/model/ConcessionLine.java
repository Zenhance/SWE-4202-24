package model;

public class ConcessionLine extends LineItem{


    public ConcessionLine(ConcessionItem pop, int i) {
        super();
    }

    public double subtotal() {
        return 0.0d;
    }

    @Override
    public String describe() {
        return "";
    }
}
