package model;

// Cart is like a shopping basket that belongs to one customer during their visit.
// It holds all the tickets they book AND any snacks they add from the concession stand.
public class Cart {

    // Max number of tickets and concession lines this cart can hold
    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS   = 20;

    // --- Fields ---
    private Customer owner;           // who this cart belongs to

    private Ticket[] tickets;         // array of booked tickets
    private int ticketCount;          // how many tickets are currently in the array

    private ConcessionItem[] items;   // array of concession items added
    private int[] qtys;               // quantity for each concession item (parallel array)
    private int itemCount;            // how many concession lines are in the arrays

    // --- Constructor ---
    // Creates an empty cart for the given customer.
    // Both arrays are allocated here but start empty (count = 0).
    public Cart(Customer owner) {
        this.owner = owner;
        this.tickets = new Ticket[MAX_TICKETS];
        this.items   = new ConcessionItem[MAX_ITEMS];
        this.qtys    = new int[MAX_ITEMS];
        this.ticketCount = 0;
        this.itemCount   = 0;
    }

    // --- Getters ---
    public Customer getOwner()           { return owner; }
    public Ticket[] getTickets()         { return tickets; }
    public int getTicketCount()          { return ticketCount; }
    public ConcessionItem[] getItems()   { return items; }
    public int[] getQtys()               { return qtys; }
    public int getItemCount()            { return itemCount; }

    // Adds a ticket to the cart (only if there's still room)
    public void addTicket(Ticket t) {
        if (ticketCount < MAX_TICKETS) {
            tickets[ticketCount] = t;
            ticketCount++;  // move the "next free slot" pointer forward
        }
        // if full, we just silently ignore (could print a warning in a real app)
    }

    // Adds a concession item with a given quantity.
    // Rejects the request if the cart is full or the quantity makes no sense.
    public void addItem(ConcessionItem c, int qty) {
        if (itemCount >= MAX_ITEMS) return;   // cart is full
        if (qty <= 0)               return;   // can't add zero or negative quantity

        items[itemCount] = c;
        qtys[itemCount]  = qty;
        itemCount++;
    }

    // Calculates the total of all ticket prices added together
    public double sumTicketsPaid() {
        double total = 0;
        for (int i = 0; i < ticketCount; i++) {
            total += tickets[i].getPricePaid();
        }
        return total;
    }

    // Calculates the raw total of all concession items (price x quantity for each line)
    public double sumConcessionsRaw() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getUnitPrice() * qtys[i];
        }
        return total;
    }

    // Checks if a specific concession item (by its code) is in the cart.
    // Used by CheckoutEngine to detect the popcorn+soda combo deal.
    public boolean hasItem(String code) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }
}
