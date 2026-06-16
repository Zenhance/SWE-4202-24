package model;

public class ComboLine extends LineItem{
    private ConcessionItem a;
    private ConcessionItem b;

    public ComboLine(ConcessionItem a, ConcessionItem b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double subtotal() {
        return a.getUnitPrice() + b.getUnitPrice();
    }
}
