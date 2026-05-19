package model;

public class Cart {
public static final int MAX_TICKETS=20;
public static final int MAX_ITEMS=20;
private Customer owner;
private Ticket[] tickets;
private int TicketCount;
private int ItemCount;
private ConcessionItem[] items;
private int[] qtys;
private int itemCount;
public Cart(Customer owner){
    this.owner=owner;
    tickets=new Ticket[MAX_TICKETS];
    items=new ConsessionItem[MAX_ITEMS];
    qtys=new int[MAX_ITEMS];
    TicketCount=0;
    itemCount=0;
}
public void addTicket(Ticket t){
    if(TicketCount<MAX_TICKETS){
        tickets[TicketCount]=1;
        TicketCount++;
    }
}
public void addItem(ConsessionItem c, int qty){
    if(itemCount<MAX_ITEMS && qty>0){
        items[itemCount]=c;
        qtys[itemCount]=qty;
        itemCount++;
    }
}

}
