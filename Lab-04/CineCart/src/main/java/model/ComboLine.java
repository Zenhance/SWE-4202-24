package model;

public abstract class ComboLine extends LineItem {
    public ComboLine(ConcessionItem pop, ConcessionItem soda) {
    }

    public double subtotal() {
        return 0;
    }
}
