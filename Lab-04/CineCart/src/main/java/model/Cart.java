package model;

public class Cart {
public static final int MAX_TICKETS=20;
public static final int MAX_ITEMS=20;
private Customer owner;
private Ticket[] tickets;
private int ticketCount;
private int ItemCount;
private ConcessionItem[] items;
private int[] qtys;
private int itemCount;
public Cart(Customer owner){
    this.owner=owner;
    tickets=new Ticket[MAX_TICKETS];
    items=new ConsessionItem[MAX_ITEMS];
    qtys=new int[MAX_ITEMS];
    ticketCount=0;
    itemCount=0;
}
public void addTicket(Ticket t){
    if(ticketCount<MAX_TICKETS){
        tickets[ticketCount]=1;
        ticketCount++;
    }
}
public void addItem(ConsessionItem c, int qty){
    if(itemCount<MAX_ITEMS && qty>0){
        items[itemCount]=c;
        qtys[itemCount]=qty;
        itemCount++;
    }
}
public Customer getOwner(){
    return owner;
}
public Ticket[] tickets(){
    return tickets;
}
public int getTicketCount(){
    return ticketCount;
}
public ConcessionItem[] getItems() {
        return items;
    }
    public int getItemCount() {
        return ItemCount;
    }
    public int[] getQtys() {
        return qtys;
    }
public int getitemCount(){
    return itemCount;
}
}
