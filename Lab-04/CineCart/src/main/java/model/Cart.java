package model;

public class Cart {

    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;

    private final Customer owner;
    private final Ticket[] tickets;
    private final int ticketCount;
    private final ConcessionItem[] items;
    private final int[] qtys;
    private final int itemCount;

    public Cart(Customer owner){
        this.owner = owner;
        this.tickets = new Ticket[MAX_TICKETS];
        this.ticketCount = 0;
        this.items = new ConcessionItem[MAX_ITEMS];
        this.qtys = new int[MAX_ITEMS];
        this.itemCount = 0;
    }
    public void addTicket(Ticket t) {
        if (ticketCount < MAX_TICKETS) {
            tickets[ticketCount++] = t;
        }
    }

    public void addItem(ConcessionItem c, int qty) {
        if (itemCount >= MAX_ITEMS || qty <= 0) return;
        items[itemCount] = c;
        qtys[itemCount] = qty;
        itemCount++;
    }

    public Customer getOwner()          { return owner; }
    public Ticket[] getTickets()        { return tickets; }
    public int getTicketCount()         { return ticketCount; }
    public ConcessionItem[] getItems()  { return items; }
    public int[] getQtys()             { return qtys; }
    public int getItemCount()           { return itemCount; }

    public double sumTicketsPaid() {
        double sum = 0;
        for (int i = 0; i < ticketCount; i++)
            sum += tickets[i].getPricePaid();
        return sum;
    }

}
