package model;

public class Cart {
    public class final int MAX_TICKETS = 20;
    public class final int MAX_ITEMS= 20;
    private final customer owner;
    private final LineItem[] lineItems;

    public Cart(customer owner, LineItem[] lineItems) {
        this.owner = owner;
        this.lineItems = lineItems;
    }
}
