package model;

public class Cart {
    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;
    private Customer owner;
    private Ticket[] tickets;
    private int ticketCount;
    private concessionItem[] items;
    private int[] qtys;
    private int itemCount;

    public Cart(Customer Owner) {
        this.owner = owner;
        tickets = new Ticket[MAX_TICKETS];
        this.ticketCount = 0;
        items = new ConcessionItem[MAX_ITEMS];
        qtys = new int[MAX_ITEMS];
        this.itemCount = 0;


    }
    public void addTicket (Ticket t)
    {
        tickets [ticketCount]=t;
        ticketCount++;
    }
    public void addItem (ConcessionItem c, int qty)
    {
        items [itemCount] =c;
        qtys [itemCount] = qty;
        itemCount++;
        if (itemCount == MAX_ITEMS || qty<=0)
        {
            return;
        }


    }
}