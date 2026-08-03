package model;

public class Cart {

    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;

    private final Customer owner;
    private final Ticket[] tickets;
    private int ticketCount;
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
    public boolean addTicket(Ticket t) {
        if (ticketCount < MAX_TICKETS) {
            tickets[ticketCount++] = t;
        }
        return false;
    }

    public boolean addItem(ConcessionItem c, int qty) {
        if (itemCount >= MAX_ITEMS || qty <= 0) return false;
        items[itemCount] = c;
        qtys[itemCount] = qty;
        itemCount++;
        return false;
    }

    public Customer getOwner()          { return owner; }
    public Ticket[] getTickets()        { return tickets; }
    public int ticketCount()         { return ticketCount; }
    public ConcessionItem[] getItems()  { return items; }
    public int[] getQtys()             { return qtys; }
    public int getItemCount()           { return itemCount; }

    public double sumTicketsPaid() {
        double sum = 0;
        for (int i = 0; i < ticketCount; i++){
            sum += tickets[i].getPricePaid();
        }
        return sum;
    }

    public double sumConcessionsRaw() {
        double sum = 0;
        for (int i = 0; i < itemCount; i++){
            sum += items[i].getUnitPrice() * qtys[i];
        }
        return sum;
    }

    public boolean hasItem(String code) {
        for (int i = 0; i < itemCount; i++)
            if (items[i].getCode().equals(code)) return true;
        return false;
    }

    public void add(StandardTicket standardTicket) {
    }

    public double grandSubtotal() {
        return 0.0d;
    }

    public LineItem[] getLines() {
        return getLines();
    }

    public boolean hasCode(String pop) {
        return pop.isEmpty();
    }

    public void add(ConcessionItem soda, int i) {
    }

    public void add(PremiumTicket premiumTicket) {
    }

    public void add(ComboLine comboLine) {
    }

    public void add(StudentTicket studentTicket) {
    }

    public void add(LineItem a) {
    }

    public void add(ConcessionLine concessionLine) {
    }

    public void add(ConcessionItem pop) {
    }
}
