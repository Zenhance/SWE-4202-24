package model;

public class Cart {
    public static final int MAX_TICKET=20;
    public static final int MAX_ITEMS=20;

    private Customer owner;
    private Ticket[] tickets;
    private int ticketCount;
    private ConcessionItem[] items;
    private int[] qtys;
    private int itemCount;
    protected LineItem[] lineItems;

    public Cart(Customer owner){
        this.owner = owner;
        this.tickets = new Ticket[MAX_TICKET];
        this.items = new ConcessionItem[MAX_ITEMS];
        this.itemCount=0;
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
        if(itemCount<MAX_ITEMS && qty>0){
            items[itemCount]=c;
            qtys[itemCount]=qty;
            itemCount++;
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
        return itemCount;
    }

    public double sumTicketsPaid(){
        double sum =0.0;
        for(int i=0;i<ticketCount;i++){
            sum+=tickets[i].getPricePaid();
        }
        return sum;
    }

    public double sumConcessionsRaw(){
        double sum =0;
        int [] qtys = getQtys();
        for(int i=0;i<itemCount;i++){
            sum+=items[i].getUnitPrice()*qtys[i];
        }
        return sum;
    }

    public boolean hasItem(String code){
        for(int i=0;i<itemCount;i++){
            if(items[i].getCode().equals(code)){
                return true;
            }
        }
        return false;
    }

    public String add(){
        return "Cart Added";
    }

    public double grandSubtotal(){

    }
}
