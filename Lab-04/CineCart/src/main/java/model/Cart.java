package model;
public class Cart {
    public static final int MAX_TICKETS=20,MAX_ITEMS=20;
    Customer owner;
    Ticket[] tickets;
    int ticketCount;
    ConcessionItem[] items;
    int[] qtys;
    int itemCount;
    public Cart(Customer owner){
        this.owner=owner;
    }
    void addTicket(){

    }
    void addItems(){}

    public Customer getOwner() {
        return owner;
    }

    public int getItemCount() {
        return itemCount;
    }

    public int[] getQtys() {
        return qtys;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public ConcessionItem[] getItems() {
        return items;
    }
}