package model;

public class ConcessionLine extends LineItem {
    public ConcessionLine(ConcessionItem item, int quantity) {
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