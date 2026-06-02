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

    public Cart(Customer owner){
        this.owner=owner;
        this.tickets=new Ticket[MAX_TICKETS];
        this.ticketCount=0;
        this.items=new ConcessionItem[MAX_ITEMS];
        this.qtys=new int[MAX_ITEMS];
        this.itemCount=0;

    }
}
