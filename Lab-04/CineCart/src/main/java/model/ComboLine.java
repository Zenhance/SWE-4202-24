package model;

public class ComboLine extends LineItem {
    public ComboLine(ConcessionItem item1, ConcessionItem item2) {
    }

    @Override
    public double subtotal() {
        return 0.0;
    }

    @Override
    public String describe() {
        return "";
    }
}