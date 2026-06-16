package model;

public abstract class LineItem {
    public abstract double subtotal();

    public abstract String describe();

    public boolean isTicketLine() {
        return false;
    }

    public boolean carriesCode(String code) {
        return false;
    }
}