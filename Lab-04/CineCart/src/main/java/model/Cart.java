package model;

public class Cart {

    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;

    private final Customer owner;
    private final Ticket[] tickets;
    private final int ticketCount;
    private final ConcessionItem[] items;
    private final int[] qtys;
    private int itemCount;

    public Cart(Customer owner){
        this.owner = owner;
        this.tickets = new Ticket[MAX_TICKETS];
        this.ticketCount = 0;
        this.items = new ConcessionItem[MAX_ITEMS];
        this.qtys = new int[MAX_ITEMS];
        this.itemCount = 0;
    }

}
