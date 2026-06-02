package model;

public class Cart {
    public static final int MAX_TICKETS=20;
    public static final int MAX_ITEMS=20;

    Customer owner;
    Ticket[] tickets;
    int ticketCount;
    concessionItem[] items;
    int [] qtys;
    int itemCount;

    public Cart(Customer owner){
        this.owner=owner;
        this.tickets=new Ticket[MAX_TICKETS];
        this.items=new concessionItem[MAX_ITEMS];
        this.qtys=new int[];
        this.itemCount=0;
    }


}
