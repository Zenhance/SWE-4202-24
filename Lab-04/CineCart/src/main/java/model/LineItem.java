package model;

public abstract class LineItem {

    double sum = 0;

    public abstract double subtotal();

    public abstract String describe();

    public abstract boolean isTicket();
}
