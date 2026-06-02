package model;

public class Cart {
    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;

    private Customer owner;
    private Ticket[] tickets;
    private int ticketCount=0;
    private ConcessionItem[] items;
    private int[] qtys;
    private int itemCount=0;

    public Cart(Customer owner) {
        this.owner=owner;
        tickets= new Ticket[MAX_TICKETS];
        items= new ConcessionItem[MAX_ITEMS];
        qtys= new int[MAX_ITEMS];
    }

    public void addTicket(Ticket t) {
        if(ticketCount<MAX_TICKETS) {
            tickets[ticketCount]=t;
            ticketCount++;
        }
    }

    public void addItem(ConcessionItem c, int qty) {
        if(itemCount<MAX_ITEMS && qty>0) {
            items[itemCount]=c;
            qtys[itemCount]=qty;
            itemCount++;
        }
    }
}