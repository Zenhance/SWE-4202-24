package model;

public class Cart {
    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;

    private Customer owner;
    private  Ticket[] tickets;
    private  int ticketCount;
    private  ConcessionItem[] items;
    private  int[] qtys = new int[MAX_ITEMS];
    private  int itemCount;

    public Cart(Customer owner){
        this.owner = owner;
        tickets  = new Ticket[MAX_TICKETS];
        items = new ConcessionItem[MAX_ITEMS];
        ticketCount = 0;
        itemCount = 0;

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

    public boolean addTicket(Ticket t){
        if (ticketCount >= MAX_TICKETS)
            throw new IllegalArgumentException("MAX TICKETS exceeded");
        tickets[ticketCount] = t;
        ticketCount++;

        return (ticketCount < MAX_TICKETS)? true : false;
    }

    public void addItem(ConcessionItem c, int qty){
        if (itemCount >= MAX_ITEMS || qty <= 0)
            throw new IllegalArgumentException("MAX ITEMS exceeded OR Qty is too low");
        items[itemCount] = c;
        qtys[itemCount] = qty;
        itemCount++;
    }

    public double sumTicketsPaid(){
        double ticketPrice = 0;
        for(int i = 0; i < ticketCount; i++){
            ticketPrice += tickets[i].getPricePaid();
        }
        return ticketPrice;
    }

    public double sumConcessionsRaw(){
        double conPrice = 0;
        for(int i = 0; i < itemCount; i++){
            conPrice += items[i].getUnitPrice() * qtys[i];
        }
        return conPrice;
    }

    public boolean hasItem(String code){

        for(int i = 0; i < itemCount; i++){
            ConcessionItem it = items[i];
            if(code.equals(it.getCode())) return true;
        }
        return false;
    }
}
