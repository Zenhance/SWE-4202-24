package model;

public class ComboLine extends LineItem{

    @Override
    public double subtotal() {
        return 0;
    }

    @Override
    public String describe() {
        return "";
    }

    @Override
    public boolean hasCoode(String code) {
        return false;
    }
}
