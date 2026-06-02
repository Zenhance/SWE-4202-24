package model;

public class Cart {
    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;
    private Customer owner;
    private Ticket[] tickets;
    private int ticketCount;
    private ConcessionItem[] items;
    private int[] qtys;
    private int itemCount;
    public Cart(Customer owner){
        this.owner = owner;
        tickets = new Ticket[MAX_TICKETS];
        items = new ConcessionItem[MAX_ITEMS];
        qtys = new int[MAX_ITEMS];
        ticketCount = 0;
        itemCount = 0;
    }
    public void addTicket(Ticket t){
        if (ticketCount>=MAX_TICKETS){return;}
        tickets[ticketCount] = t;
        ticketCount++;
    }
}
