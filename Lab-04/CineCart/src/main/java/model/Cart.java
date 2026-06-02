package model;

public class Cart {
    //Constants
    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;
    //Fields
    private final Customer owner;
    private final Ticket[] tickets;
    private int ticketCount;
    private final ConcessionItem[] items;
    private final int[] qtys;
    private int itemCount;

    public Cart(Customer owner){
        this.owner = owner;
        tickets = new Ticket[MAX_TICKETS];
        items = new ConcessionItem[MAX_ITEMS];
        qtys = new int[MAX_ITEMS];

        ticketCount = 0;
        itemCount = 0;
    }

        public boolean addTicket(Ticket t){
        if(ticketCount < MAX_TICKETS){
            tickets[ticketCount] = t;
            ticketCount++;
            return true;
        }
        else  return false;
    }

    public boolean addItem(ConcessionItem c, int qty){
        if(itemCount>=MAX_ITEMS || qty <= 0) return false   ;

        items[itemCount] = c;
        qtys[itemCount] = qty;
        itemCount++;
        return true;
    }
    //getOwner(), getTickets(), getTicketCount(), getItems(), getQtys(), getItemCount().
    public Customer getOwner(){
        return owner;
    }
    public Ticket[] getTickets(){
            Ticket[] newTickets = new Ticket[ticketCount];
            System.arraycopy(tickets, 0, newTickets, 0, ticketCount);
            return newTickets;
    }
    public int getTicketCount(){
        return ticketCount;
    }
    public ConcessionItem[] getItems(){
            ConcessionItem[] newItems = new ConcessionItem[itemCount];
            System.arraycopy(items, 0, newItems, 0, itemCount);
        return newItems;
    }
    public int[] getQtys(){
        return new  int[itemCount];
    }
    public int getItemCount(){
        return itemCount;
    }

    public double sumTicketsPaid(){
        double sum = 0;
        for(int i=0;i<ticketCount;i++){
            sum+=tickets[i].getPricePaid();
        }
        return sum;
    }

    public double sumConcessionsRaw(){
        double sum = 0;
        for(int i=0;i<itemCount;i++){
            sum+=items[i].getUnitPrice()*qtys[i];
        }
        return sum;
    }

    public boolean hasItem(String code){
        for(int i=0;i<itemCount;i++){
            if(items[i].getCode().equals(code)) return true;
        }
        return false;
    }


}
