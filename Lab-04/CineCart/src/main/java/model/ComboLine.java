package model;

public class ComboLine extends LineItem{
    public ComboLine(ConcessionItem pop, ConcessionItem soda) {
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
