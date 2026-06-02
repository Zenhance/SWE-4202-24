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

    public Cart(Customer owner){
        this.owner = owner;
        this.tickets = new Ticket[MAX_TICKET];
        this.items = new ConcessionItem[MAX_ITEMS];
        this.itemcount=0;
        this.ticketCount=0;
        this.qtys=new int[MAX_ITEMS];
    }

    public void addTicket(Ticket t){
        if(ticketCount<MAX_TICKET){
            tickets[ticketCount]=t;
            ticketCount++;
        }

    }

    public void addItem(ConcessionItem c,int qty){
        if(itemcount<MAX_ITEMS && qty>0){
            items[itemcount]=c;
            qtys[itemcount]=qty;
            itemcount++;
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

    public int getItemCount() {
        return itemcount;
    }

    public double sumTicketsPaid(){
        double sum =0;
        for(int i=0;i<MAX_TICKET;i++){
            sum+=tickets[i].getPricePaid();
        }
        return sum;
    }

    public double sumConcessionsRaw(){
        double sum =0;
        for(int i=0;i<MAX_ITEMS;i++){
            sum+=items[i].getUnitPrice()*qtys[i];
        }
        return sum;
    }

    public boolean hasItem(String code){
        for(int i=0;i<MAX_ITEMS;i++){
            if(items[i].getCode().equals(code)){
                return true;
            }
        }
        return false;
    }
}
