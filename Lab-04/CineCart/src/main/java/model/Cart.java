package model;

public class Cart {
    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;

    private Customer owner;
    private Ticket[] tickets;
    private int ticketCount;
    private ConcessionItem[] items;
    private int[] qtys;
    private int itemCount;

    public Cart(Customer owner){
        this.tickets = new Ticket[MAX_TICKETS];
        this.items = new Item[MAX_ITEMS];
        this.owner = owner;
        ticketCount = 0;
        itemCount = 0;
        qtys = new int[MAX_ITEMS];
    }

    void addTicket(Ticket t){
        if(ticketCount==MAX_TICKETS){

        }else{
        ticketCount++;}
    }

    void addItem(ConcessionItem c, int qty){
        if(itemcount == MAX_ITEMS) return;
        if(qtys<=0) return;

        items[itemCount] = c;
        qtys[itemCount++] = qty;

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
        double sum 0;

        for(i = 0; i<ticketCount;i++){
            sum += tickets[i].getPricePaid();
        }
        return sum;
    }
    public double sumConcessionsRaw(){
        double sum = 0;
        for(i =0; i<itemCount;i++){
            sum += items[i].getUnitPrice()*qtys[i];
        }
        return sum;
    }

    public boolean hasItem(String code){
        for(i =0; i<itemCount;i++){
            if(code.equals(items[i].getCode()))
                return true;
        }
        return false;
    }
}
