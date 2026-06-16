package model;

public class ConcessionLine extends LineItem{
    public ConcessionLine(ConcessionItem pop, int i) {

    }


    @Override
    public double subtotal() {
        return 0;
    }

    @Override
    public String describe() {
        return "";
    }
}
