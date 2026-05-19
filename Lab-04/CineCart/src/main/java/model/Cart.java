package model;

public class Cart {
    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;

    private Customer owner;
    private  Ticket[] tickets;
    private  int ticketCount;
    private  ConcessionItem[] items;
    private  int[] qtys = new int[MAX_ITEMS];
    private  int itemCount;

    public Cart(Customer owner){
        this.owner = owner;
        tickets  = new Ticket[MAX_TICKETS];
        items = new ConcessionItem[MAX_ITEMS];
        ticketCount = 0;
        itemCount = 0;

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

    public void addTicket(Ticket t){
        if (ticketCount >= MAX_TICKETS)
            throw new IllegalArgumentException("MAX TICKETS exceeded");
        tickets[ticketCount] = t;
        ticketCount++;
    }
}
