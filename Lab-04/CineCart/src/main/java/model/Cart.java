package model;

public class Cart {
    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;

    private final Customer owner;
    private LineItem[] lineItems;
    private int ticketCount;
//    private final ConcessionItem[] items;
//    private final int[] qtys;
    private int lineCount;

    public Cart(Customer owner) {
        this.owner = owner;
        this.lineItems = new LineItem[MAX_ITEMS];
//        this.tickets = new Ticket[MAX_TICKETS];
//        this.items = new ConcessionItem[MAX_ITEMS];
//        this.qtys = new int[MAX_ITEMS];
//        ticketCount = 0;
        lineCount = 0;
    }

//    public boolean addTicket(Ticket t) {
//        if (ticketCount>=MAX_TICKETS) return false;
//
//        tickets[ticketCount++] = t;
//        return true;
//    }
//
//    public boolean addItem(ConcessionItem c, int qty) {
//        if (itemCount>=MAX_ITEMS) return false;
//        if (qty<=0) return false;
//
//        items[itemCount] = c;
//        qtys[itemCount++] = qty;
//        return true;
//    }

    public void add(LineItem a) {
        if (lineCount >= MAX_ITEMS) return;;
        if (a == null) return;
        lineItems[lineCount++] = a;
    }

    public void add(ConcessionItem c) {
        ConcessionLine c1 = new ConcessionLine(c, 1);
        if (lineCount >= MAX_ITEMS) return;;
        if (c == null) return;
        lineItems[lineCount++] = c1;
    }

    public void add(ConcessionItem c, int qty) {
        ConcessionLine c1 = new ConcessionLine(c, qty);
        if (lineCount >= MAX_ITEMS) return;
        if(qty<0) return;
        if (c == null) return;
        lineItems[lineCount++] = c1;
    }

    public Customer getOwner() {
        return owner;
    }

//    public Ticket[] getTickets() {
//        Ticket[] tickets = new Ticket[ticketCount];
//        System.arraycopy(this.tickets, 0, tickets, 0, ticketCount);
//        return tickets;
//    }

//    public int getTicketCount() {
//        return ticketCount;
//    }

//    public ConcessionItem[] getItems() {
//        ConcessionItem[] items = new ConcessionItem[itemCount];
//        System.arraycopy(this.items, 0, items, 0, itemCount);
//        return items;
//    }

//    public int[] getQtys() {
//        int[] qtys = new int[itemCount];
//        System.arraycopy(this.qtys, 0, qtys, 0, itemCount);
//        return qtys;
//    }

//    public int getItemCount() {
//        return itemCount;
//    }

    public LineItem[] getLines() {
        LineItem[] lines = new LineItem[lineCount];
        System.arraycopy(lineItems, 0, lines, 0, lineCount);
        return lines;
    }

    public double grandSubtotal() {
        return 0.0;
    }
//    public double sumTicketsPaid() {
//        double sum = 0;
//
//        for (int i=0; i<ticketCount; i++) {
//            sum += tickets[i].getPricePaid();
//        }
//
//        return sum;
//    }

//    public double sumConcessionsRaw() {
//        double sum = 0;
//
//        for (int i=0; i<itemCount; i++) {
//            sum += items[i].getUnitPrice()*qtys[i];
//        }
//
//        return sum;
//    }

//    public boolean hasItem(String code) {
//        for (int i=0; i<itemCount; i++) {
//            if (code.equals(items[i].getCode()))
//                return true;
//        }
//        return false;
//    }
}
