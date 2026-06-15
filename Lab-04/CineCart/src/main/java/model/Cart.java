package model;

public class Cart {
    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;

    Customer owner;
    Ticket[] tickets;
    int ticketCount;
    ConcessionItem[] items;
    int[] qtys;
    int itemCount;

    public Cart(Customer owner) {
        this.owner = owner;
        tickets = new Ticket[MAX_TICKETS];
        items = new ConcessionItem[MAX_ITEMS];
        ticketCount = 0;
        itemCount = 0;
    }

    public void addTicket(Ticket t) {

    }

    void addItem(ConcessionItem c, int qty) {

    }

    public Customer getOwner() {
        return owner;
    }
    public Ticket[] getTickets() {
        return tickets;
    }
    public int getTicketCount() {
        return ticketCount;
    }
    public ConcessionItem[] getItems() {
        return items;
    }
    public int[] getQtys() {
        return qtys;
    }
    public int getItemCount() {
        return itemCount;
    }

    public double sumTicketPaid() {

    }

    public double sumConcessionRaw() {

    }

    public boolean hasItem(String code) {}

}
