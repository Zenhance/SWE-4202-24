package model;

public class Cart {
    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;

    private Customer owner;
    private  Ticket[] tickets = new Ticket[MAX_TICKETS];
    private  int ticketCount = 0;
    private  ConcessionItem[] items = new ConcessionItem[MAX_ITEMS];
    private  int[] qtys = new int[MAX_ITEMS];
    private  int itemCount = 0;

    public Cart(Customer owner){
        this.owner = owner;
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
}
