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
     this.tickets= new Ticket[MAX_TICKETS];
     this.qtys=qtys;
     this.items=new ConcessionItem[MAX_ITEMS];
     this.ticketCount=0;

 }
 public void addTicket(Ticket t){
             if(ticketCount<MAX_TICKETS){

             }
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


public Ticket[] getTickets() {
    return tickets;
}
   public void addItem(ConcessionItem c, int qty){

    }
    public double sumTicketsPaid(){

    }
    public double sumConcessionsRaw(){

    }
    public boolean hasItem(String code){

    }

}