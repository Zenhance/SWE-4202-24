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
        this.ticketcount = 0;
        this.itemCount = 0;
        this.qtys = new int[MAX_ITEMS];
    }

    public boolean addTicket(Ticket t){
        if (ticketcount >= MAX_TICKETS) return false;
        tickets[ticketcount++] = t;
        return true;
    }

    public boolean addItem(ConcessionItem c, int qty){
        if (qty <= 0 || itemCount >= MAX_ITEMS) return false;
        items[itemCount] = c;
        qtys[itemCount] = qty;
        itemCount++;
        return true;
    }

    public Customer getOwner() {
        return owner;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public int getTicketCount() {
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

    public double sumTicketsPaid(){
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
