package model;

public class Cart {
    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;
    Customer owner;
    Ticket[] tickets;
    int ticketCount;
    ConcessionItem[] items;
    int[] qtys;
    int itemCount;

    public Cart(Customer owner) {
        this.itemCount = itemCount;
        this.owner = owner;
        this.tickets = new Ticket[MAX_TICKETS];
        this.qtys = new int[MAX_ITEMS];
        this.items = new ConcessionItem[MAX_ITEMS];
        this.ticketCount = 0;

    }

    public void addTicket(Ticket t) {
        if (ticketCount < MAX_TICKETS) {
            tickets[ticketCount] = t;
            ticketCount++;
        }
    }

    public void addItem(ConcessionItem c, int qty) {
        if (ticketCount < MAX_ITEMS && qty > 0) {
            items[itemCount] = c;
            qtys[itemCount] = qty;
            itemCount++;

        }
    }

    public Customer getOwner() {
        return owner;
    }

    public ConcessionItem[] getItems() {
        return items;
    }

    public int getItemCount() {
        return itemCount;
    }

    public int[] getQtys() {
        return qtys;
    }

    public int getTicketCount() {
        return ticketCount;
    }


    public Ticket[] getTickets() {
        return tickets;
    }

    public double sumTicketsPaid() {
        double totalPrice = 0.0;
        for (int i = 0; i < ticketCount; i++) {
            totalPrice += tickets[i].getPricePaid();

        }
        return totalPrice;
    }

    public double sumConcessionsRaw() {
        double totalSum = 0.0;
        for (int i = 0; i < itemCount; i++) {
            totalSum += items[i].getUnitPrice() * qtys[i];
        }
        return totalSum;
    }

    public boolean hasItem(String code) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

}