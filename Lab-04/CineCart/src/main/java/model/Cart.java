package model;

public class Cart {
    //constants
    public static final int MAX_TICKETS=20;
    public static final int MAX_ITEMS=20;
    //fields
    private Customer owner;
    private Ticket[] tickets;
    private int ticketCount;
    private ConcessionItem[] items;
    private int[] qtys;
    private int itemCount;
    //constructor
    public Cart(Customer owner) {
        this.owner = owner;
        tickets = new Ticket[MAX_TICKETS];
        items = new ConcessionItem[MAX_ITEMS];
        qtys = new int[MAX_ITEMS];
        ticketCount = 0;
        itemCount = 0;
    }
}
