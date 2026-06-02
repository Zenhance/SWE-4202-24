package model;

public class Cart{
    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;

    private Customer owner;
    private Ticket[] tickets;
    private ConcessionItem[] items;
    private int ticketCount;
    private int[] qtys;
    private int itemCount;

    public Cart(Customer owner) {
        this.owner       = owner;
        this.tickets     = new Ticket[MAX_TICKETS];
        this.ticketCount = 0;
        this.items       = new ConcessionItem[MAX_ITEMS];
        this.qtys        = new int[MAX_ITEMS];
        this.itemCount   = 0;
    }

    public void addTicket(Ticket t) {
        if (ticketCount >= MAX_TICKETS) {
            System.out.println("Cart is full.");
            return;
        }
        tickets[ticketCount++] = t;
    }

    public void addItem(ConcessionItem c, int qty) {
        if (itemCount >= MAX_ITEMS) {
            System.out.println("Cart is full.");
            return;
        }
        if (qty <= 0) {
            System.out.println("Invalid quantity.");
            return;
        }
        items[itemCount] = c;
        qtys[itemCount]  = qty;
        itemCount++;
    }


}