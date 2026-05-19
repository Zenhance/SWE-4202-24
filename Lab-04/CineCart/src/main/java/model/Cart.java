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
 public Cart(Customer owner,Ticket[] tickets,int ticketCount,ConcessionItem[] items,int[] qtys,int itemCount){
     this.itemCount=itemCount;
     this.owner=owner;
     this.tickets=tickets;
     this.qtys=qtys;
     this.itemCount=itemCount;
     this.items=items;

 }
 public void addTicket(Ticket t){

 }
 public Customer getOwner(){
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
}

public Ticket getTicket(){
    return
}