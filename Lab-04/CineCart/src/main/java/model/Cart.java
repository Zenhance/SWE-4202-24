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
        this.tickets = new Ticket[MAX_TICKETS];
        this.items = new Item[MAX_ITEMS];
        this.owner = owner;
        ticketCount = 0;
        itemCount = 0;
        qtys = new int[MAX_ITEMS];
    }

    void addTicket(Ticket t){
        if(ticketCount==MAX_TICKETS){

        }else{
        ticketCount++;}
    }

    void addItem(ConcessionItem c, int qty){
        if(itemcount == MAX_ITEMS)

    }
}
