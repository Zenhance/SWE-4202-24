package model;

public class Cart {
    public static final int MAX_TICKETS=20;
    public static final int MAX_ITEMS=20;

    private Customer owner;
    private Ticket[] tickets;
    private int ticketCount;
    private ConcessionItem[] items;
    private int[] qtys;
    private int itemCount;
    public Cart(Customer owner){
        this.owner=owner;
        tickets= new Ticket[MAX_TICKETS];
        items=new ConcessionItem[MAX_ITEMS];
        qtys= new int[MAX_ITEMS];
        ticketCount=0;
        itemCount=0;
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
        return items;
    }

    public int getItemCount() {
        return itemCount;
    }

    public int[] getQtys() {
        return qtys;
    }

    public void addTicket(Ticket t){
        if(ticketCount<MAX_TICKETS){
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
    public double sumTicketsPaid(){
        double sum=0;
        for(int i=0;i<ticketCount; i++){
            sum+=tickets[i].getPricePaid();

        }
        return sum;
    }
    public double sumConcessionsRaw(){
        double total= 0;
        for (int i= 0; i<itemCount;i++) {
            total+=items[i].getUnitPrice()*qtys[i];
        }
        return total;
    }
    public boolean hasItem(String code){
        for (int i=0;i<itemCount;i++) {
            if(items[i].getCode().equals(code)){
                return true;
            }
        }
        return false;
    }
}
