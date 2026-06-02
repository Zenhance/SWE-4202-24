package model;

public class  Cart {

    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;

      private Customer owner;
      private Ticket[] tickets;
      private int ticketCount;
      private ConcessionItem[] items;
      private int[] qtys;
      private int itemCount;

public Cart (Customer owner){
    this.owner=owner;
    tickets= new Ticket[MAX_TICKETS];
    items= new ConcessionItem[MAX_ITEMS];
    qyts= new int[MAX_ITEMS];
}

public boolean addTicket(Ticket t){

    boolean res=false;
    if (ticketCount < MAX_TICKETS){
        tickets[ticketCount] = t;
        ticketCount++;
        res=true;
    }  return res;
}

public boolean addItem(ConcessionItem c,int qty){
    boolean res=false;
    if(itemCount<MAX_ITEMS){
        items[itemCount]= c;
    }
}
}
