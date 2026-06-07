package model;

import java.util.Arrays;

public class Cart {
    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;

    private Customer owner;
    private Ticket[] tickets;
    private int ticketCount;
    private ConcessionItem[] items;
    private int[] qtys;
    private int itemCount;

    public Cart(Customer owner) {
        this.owner = owner;
        this.tickets = new Ticket[MAX_TICKETS];
        this.items = new ConcessionItem[MAX_ITEMS];
        this.qtys = new int[MAX_ITEMS];
        ticketCount = 0;
        itemCount = 0;
    }

    public boolean addTicket(Ticket t) {
        if (ticketCount>=MAX_TICKETS) return false;

        tickets[ticketCount++] = t;
        return true;
    }

    public boolean addItem(ConcessionItem c, int qty) {
        if (itemCount>=MAX_ITEMS) return false;
        if (qty<=0) return false;

        items[itemCount] = c;
        qtys[itemCount++] = qty;
        return true;
    }

    public Customer getOwner() {
        return owner;
    }

    public Ticket[] getTickets() {
        return Arrays.copyOf(tickets, ticketCount);
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public ConcessionItem[] getItems() {
        return Arrays.copyOf(items, itemCount);
    }

    public int[] getQtys() {
        return Arrays.copyOf(qtys, itemCount);
    }

    public int getItemCount() {
        return itemCount;
    }

    public double sumTicketsPaid() {
        double sum = 0;

        for (int i=0; i<ticketCount; i++) {
            sum += tickets[i].getPricePaid();
        }

        return sum;
    }

    public double sumConcessionsRaw() {
        double sum = 0;

        for (int i=0; i<itemCount; i++) {
            sum += items[i].getUnitPrice()*qtys[i];
        }

        return sum;
    }

    public boolean hasItem(String code) {
        for (int i=0; i<itemCount; i++) {
            if (code.equals(items[i].getCode()))
                return true;
        }
        return false;
    }
}
