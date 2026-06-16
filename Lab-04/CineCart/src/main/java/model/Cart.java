package model;

public class Cart {
    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;
    private Customer owner;
    private  AbstractTicket[] tickets;
    private int ticketCount;
    private ConcessionItem[] items;
    private int[] qtys;
    private int itemCount;

    public Cart(Customer owner){
        this.owner = owner;
        tickets = new AbstractTicket[][MAX_TICKETS];
        ticketCount = 0;
        items = new ConcessionItem[MAX_ITEMS];
        itemCount = 0;
        qtys = new int[MAX_ITEMS];
    }

    public boolean addTicket(Ticket t){
        if(ticketCount<MAX_TICKETS) {
            tickets[ticketCount] = t;
            ticketCount++;
        return true;
        }
        return false;
    }

    public boolean addItem(ConcessionItem c, int qty){
        if (itemCount >= MAX_ITEMS) {
            System.out.println("Your cart is full!");
            return false;
        }
        if (qty <= 0) {
            System.out.println("Invalid quantity");
            return false;
        }
        items[itemCount] = c;
        qtys[itemCount] = qty;
        itemCount++;
    return true;
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

    public double sumTicketsPaid(){
        double sum = 0;
        for (int i = 0 ; i<ticketCount; i++){
           sum+= tickets[i].getPricePaid();
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
