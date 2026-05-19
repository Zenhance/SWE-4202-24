package model;

public class Cart {
    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;
    Customer owner;
    Ticket[] tickets;
    int ticketCount;
    ConcessionItem[] items;
    int[] qtys;
    int itemCount;
    Cart(Customer owner){
        this.owner = owner;
        this.tickets = new Ticket[MAX_TICKETS];
        this.items = new ConcessionItem[MAX_ITEMS];
        this.qtys = new int[MAX_ITEMS];
        this.itemCount = 0;
        this.ticketCount = 0;
    }

    public ConcessionItem[] getItems() {
        return items;
    }

    public Customer getOwner() {
        return owner;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public int getItemCount() {
        return itemCount;
    }

    public int[] getQtys() {
        return qtys;
    }
    void addTicket(Ticket t){
        if(ticketCount<MAX_TICKETS){
            this.tickets[this.ticketCount] = t;
            this.ticketCount++;
        }
    }

    public void addItem(ConcessionItem c, int qty){
        if (itemCount < MAX_ITEMS && qty > 0) {
            this.items[this.itemCount] = c;
            this.qtys[this.itemCount] = qty;
            this.itemCount++;
        }
    }
    public double sumTicketsPaid(){
        double sum=0,0;
        for(int i=0;i<ticketCount;i++){
          sum+=tickets[i].getPricePaid();
        }
        return sum;
    }
    public double sumConcessionsRaw(){
        double sum=0;
        for(int i=0;i<itemCount;i++){
            sum+=items[i].getUnitPrice()*qtys[i];
        }
        return sum;
    }
    public boolean hasItem(String code){
        for(int i=0;i<itemCount;i++){
            if(items[i].getName().equals(code)){
                return true;
            }
        }
        return false;
    }


}
