package model;

public class Cart {
    public static final int MAX_TICKET=20;
    public static final int MAX_ITEMS=20;

    private Customer owner;
    private Ticket[] tickets;
    private int ticketCount;
    private ConcessionItem[] items;
    private int[] qtys;
    private int itemcount;

    Cart(Customer owner){
        this.owner = owner;
        this.tickets = new Ticket[MAX_TICKET];
        this.items = new ConcessionItem[MAX_ITEMS];
        this.itemcount=0;
        this.ticketCount=0;
    }
}
