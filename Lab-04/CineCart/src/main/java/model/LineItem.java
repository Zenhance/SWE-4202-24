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
    public int getId() {
        return id;
    }
    public int getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public StandardTicket getTicket() {
        return ticket;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setTicket(StandardTicket ticket) {
        this.ticket = ticket;
    }

}
