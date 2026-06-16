package model;

public class Cart {
    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;
    private Customer owner;
    private AbstractTicket[] tickets = new AbstractTicket[MAX_TICKETS];
    private int ticketCount;
    private ConcessionItem[] items;
    private int[] qtys;
    private int itemCount;


    public Cart(Customer owner) {
        this.owner = owner;
        this.ticketCount = 0;
        items = new ConcessionItem[MAX_ITEMS];
        qtys = new int[MAX_ITEMS];
        this.itemCount = 0;
    }

    public boolean addTicket(AbstractTicket t) {
        boolean res = false;
        if (ticketCount < MAX_TICKETS) {
            tickets[ticketCount] = t;
            ticketCount++;
            res = true;
        }
        return res;
    }

    public boolean addItem(ConcessionItem c, int qty) {
        boolean res = false;
        if (itemCount < MAX_ITEMS) {
            items[itemCount] = c;
            qtys[itemCount] = qty;
            itemCount++;
            res = true;
        }
        return res;
    }

    public Customer getOwner() {
        return owner;
    }

    public AbstractTicket[] getTickets() {
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


    public double sumTicketsPaid() {
        double sum = 0;
        for (int i = 0; i < MAX_TICKETS; i++) {
            sum += tickets[i].getBase();
        }
        return sum;
    }

    public double sumConcessionsRaw() {
        double sum = 0;
        for (int i = 0; i < itemCount; i++) {
            sum += items[i].getUnitPrice() * qtys[i];
        }
        return sum;
    }

    public boolean hasItem(String code) {
        for (int i = 0; i < MAX_ITEMS; i++) {
            if (items[i].getCode().equals(code)) {
                return true;
            }

        }
        return false;
    }




}
