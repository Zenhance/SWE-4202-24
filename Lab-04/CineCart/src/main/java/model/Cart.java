package model;

public class Cart {
    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;

    private Customer owner;
    private Ticket[] tickets;
    private int ticketcount;
    private ConcessionItem[] items;
    private int[] qtys;
    private int itemCount;

    public Cart(Customer owner) {
        this.owner = owner;
        this.tickets = new Ticket[MAX_TICKETS];
        this.items = new ConcessionItem[MAX_ITEMS];
        this.qtys = new int[MAX_ITEMS];
        this.ticketcount = 0;
        this.itemCount = 0;
    }

    public void addTicket(Ticket t){
        if(ticketcount < MAX_TICKETS){
            tickets[ticketcount] = t;
            ticketcount++;
        }
    }

    public void addItem(ConcessionItem c, int qty){
        if(itemCount < MAX_ITEMS){
            items[itemCount] = c;
            qtys[itemCount] = qty;
            itemCount++;
        }
    }

    public Customer getOwner() {
        return owner;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public int getTicketcount() {
        return ticketcount;
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

    public double sumTicketPaid(){
        int sum = 0;
        for(int i = 0; i < ticketcount; i++){
            sum += tickets[i].getPricePaid();
        }
        return sum;
    }

    public double sumConcessionsRaw(){
        int sum = 0;
        for(int i = 0; i < itemCount; i++){
            sum += (items[i].getUnitPrice() * qtys[i]);
        }
        return sum;
    }

    public boolean hasItem(String code){
        for(int i = 0; i < itemCount; i++){
            if(items[i].getCode().equals(code)){
                return true;
            }
        }
        return false;
    }


}
