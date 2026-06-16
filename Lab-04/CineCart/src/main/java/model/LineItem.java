package model;

public class LineItem {
    private int id;
    private int price;
    private int quantity;
    private StandardTicket ticket;

    public LineItem(int id, int price, int quantity, StandardTicket ticket) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.ticket = ticket;
    }
}
