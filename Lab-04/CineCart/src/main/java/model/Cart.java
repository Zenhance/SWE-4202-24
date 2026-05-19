package model;

public class Cart {
    public static final int MAX_TICKET=20;
    public static final int MAX_ITEMS=20;

    private Customer owner;
    private Ticket[] tickets;
    private int ticketCount;
    private ConcessionItem[] items;
    private int[] qtys;
    private int itemcount;

    Cart(Customer owner){
        this.owner = owner;
        this.tickets = new Ticket[MAX_TICKET];
        this.items = new ConcessionItem[MAX_ITEMS];
        this.itemcount=0;
        this.ticketCount=0;
    }

    public void addTicket(Ticket t){
        if(ticketCount<MAX_TICKET){
            tickets[ticketCount]=t;
            ticketCount++;
        }

    }

    public void addItem(ConcessionItem c,int qty){
        if(itemcount<MAX_ITEMS && qty<=0){
            items[itemcount]=c;
            itemcount+=qty;
        }
    }

    public Customer getOwner() {
        return owner;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public ConcessionItem[] getItems() {
        return items;
    }

    public int[] getQtys() {
        return qtys;
    }

    public int getItemcount() {
        return itemcount;
    }

    public double sumTicketPaid(){
        double sum =0;
        for(int i=0;i<MAX_TICKET;i++){
            sum+=tickets[i].getPricePaid();
        }
        return sum;
    }
}
