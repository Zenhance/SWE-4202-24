package model;

public class Cart {
    public static final int MAX_TICKET=20;
    public static final int MAX_ITEMS=20;

    private Customer owner;
    private Ticket[] tickets;
    private int ticketCount;
    private ConcessionItem[] items;
    private int[] qtys;
    private int itemCount;

    public Cart(Customer owner){
        this.owner=owner;
        this.tickets=new Ticket[MAX_TICKET];
        this.ticketCount=0;
        this.items=new ConcessionItem[MAX_ITEMS];
        this.qtys=new int[MAX_ITEMS];
        this.itemCount=0;
}
public void addTicket(Ticket t) {
    if (ticketCount < MAX_TICKET) {
        tickets[ticketCount] = t;
        ticketCount++;
    }
}

public void addItem(ConcessionItem c,int qty) {
    if (itemCount < MAX_ITEMS && qty > 0) {
        items[itemCount] = c;
        qtys[itemCount] = qty;
        itemCount++;
    }
}

public Customer getOwner() {
    return owner;
}

public Ticket[] getTickets() {
    return tickets;
}

public int getTicketCount() {
        return ticketCount;
    }

public ConcessionItem[] getItems() {
    return items;
}
public int[] getQtys() {
    return qtys;
}
public int getItemCount() {
    return itemCount;
}

public double sumTicektsPaid() {
    double total = 0.0;

    for (int i = 0; i < ticketCount; i++) {
        total += tickets[i].getPricePaid();
    }
    return total;
}




