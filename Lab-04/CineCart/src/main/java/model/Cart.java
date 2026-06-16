package model;

public class Cart {
    public static final int MAX_TICKETS=20;
    public static final int MAX_ITEMS=20;
    private Customer owner;
    private Ticket[] tickets;
    public int ticketCount;
    private ConcessionItem[] items;
    private int[] qtys;
    private int itemCount;

    public Cart(Customer owner) {
        this.owner = owner;
        this.tickets = new Ticket[MAX_TICKETS];
        this.ticketCount = 0;
        this.items = new ConcessionItem[MAX_ITEMS];
        this.qtys = new int[MAX_ITEMS];
        this.itemCount = 0;
    }
    public String get;
    public Customer getOwner()          { return owner; }
    public Ticket[] getTickets()        { return tickets; }
    public int getTicketCount()         { return ticketCount; }
    public ConcessionItem[] getItems()  { return items; }
    public int[] getQtys()             { return qtys; }
    public int getItemCount()           { return itemCount; }


    public void addTicket(Ticket t) {
        if (ticketCount < MAX_TICKETS) {
            tickets[ticketCount] = t;
            ticketCount++;
        }
    }
    public void addItem(ConcessionItem c, int qty) {
        if (itemCount >= MAX_ITEMS) return;
        if (qty <= 0) return;
        items[itemCount] = c;
        qtys[itemCount]  = qty;
        itemCount++;
    }
    public double sumTicketsPaid() {
        double total = 0;
        for (int i = 0; i < ticketCount; i++) {
            total += tickets[i].getPricePaid();
        }
        return total;
    }
    public double sumConcessionsRaw() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getUnitPrice() * qtys[i];
        }
        return total;

     }
    public boolean hasItem(String code) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    public void add(VIPTicket vipTicket) {

    }
    public void add(ConcessionLine standardTicket) {

    }
    public void add(StandardTicket vipTicket) {

    }
    public void add(ComboLine vipTicket, int i) {

    }

    public void getLines() {
        return;
    }

    public double grandSubtotal() {
        return 0.0;
    }

    public void add(StudentTicket studentTicket) {
        return;
    }

    public int ticketCount() {
        return 0;
    }
}