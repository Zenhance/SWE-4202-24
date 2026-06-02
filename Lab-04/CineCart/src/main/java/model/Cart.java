package model;

public class Cart {
    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS =20;
    private Customer owner;
    private Ticket[] tickets;
    private int ticketCount;
    private  ConcessionItem[] items;
    private int[] qtys;
    private int itemCount;

    public Cart(Customer owner){
    this.owner=owner;
    tickets=new Ticket[MAX_TICKETS];
    items=new ConcessionItem[MAX_ITEMS];
    qtys= new int[MAX_ITEMS];
    ticketCount=0;
    itemCount=0;
}
public void addTicket(Ticket t){
        if(ticketCount>=MAX_TICKETS)
            return;
        else{
            tickets[ticketCount]=t;
            ticketCount++;
        }
}

public void addItem(ConcessionItem c, int qty){
        if(itemCount>=MAX_ITEMS){
            return;
        }
        else if(qty==0){
            return ;
        }
        else {
            items[itemCount]=c;
            qtys[itemCount]=qty;
            itemCount++;
        }
}

public Customer getOwner(){
        return owner;
}
public Ticket[] getTickets(){
        return tickets;
}
public int getTicketCount(){
        return ticketCount;
}

    public ConcessionItem[] getItems() {
        return this.items;
    }

    public int[] getQtys(){
        return qtys;
    }
    public int  getItemCount(){
        return itemCount;
    }


}
