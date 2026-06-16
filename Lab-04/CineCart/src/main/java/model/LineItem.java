package model;

public abstract class LineItem {
    public abstract double subtotal();
    public abstract String describe();
    public boolean isTicket() {
        return true;
    }
    public boolean hasCode(String code) {
        return true;
    }
}