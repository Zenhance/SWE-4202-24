package model;

public class Cart {

    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;

    private Customer owner;
    private Ticket[] tickets;
    private int ticketCount;
    private ConcessionItem[] items;
    private int[] qtys;
    int itemCount;

    public Cart(Customer owner){
        this.owner = owner;
        tickets = new Ticket[MAX_TICKETS];
        items = new ConcessionItem[MAX_ITEMS];
        qtys = new int[MAX_ITEMS];
    }

    public void addTicket(Ticket t){
        if (ticketCount < MAX_TICKETS){
            tickets[ticketCount] = t;
            ticketCount++;
        }
    }

    public void addItem(ConcessionItem c, int qty){
        if(itemCount < MAX_ITEMS){
            items[itemCount] = c;
            qtys[itemCount] = qty;
            itemCount++;
        }
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public Customer getOwner() {
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

    public double sumTicketsPaid(){
        double sum = 0.0;
        for (Ticket t : tickets){
            sum += t.getPricePaid();
        }

        return sum;
    }

    public double sumConcessionsRaw(){
        double sum = 0.0;
        for (int i = 0; i < itemCount; i++){
            sum += items[i].getUnitPrice() * qtys[i];
        }

        return sum;
    }

    public boolean hasItem(String code){

        boolean found = false;
        for (int i = 0; i < itemCount; i++){
            if(code.equals(items[i].getCode())){
                found = true;
                break;
            }
        }

        return found;
    }
}
