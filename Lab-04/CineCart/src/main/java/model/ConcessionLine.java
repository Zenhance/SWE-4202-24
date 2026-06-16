package model;

public class ConcessionLine extends LineItem{
    @Override
    public double subtotal() {
        return 0;
    }

    @Override
    public String describe() {
        return "";
    }
}
