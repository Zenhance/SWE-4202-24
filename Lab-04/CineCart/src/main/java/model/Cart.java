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

    Cart(Customer owner) {
        this.owner=owner;
        tickets= new Ticket[MAX_TICKETS];
        items= new ConcessionItem[MAX_ITEMS];
        qtys= new int[MAX_ITEMS];

        int ticketCount=0;
        int  itemCoount=0;
    }
}