package model;

public class Cart {
    public static final int MAX_TICKETS=20;
    public static final int MAX_ITEMS=20;

    Customer owner;
    Ticket[] tickets;
    int ticketCount;
    concessionItem[] items;
    int [] qtys;
    int itemCount;

    public Cart(Customer owner){
        this.owner=owner;
        this.tickets=new Ticket[MAX_TICKETS];
        this.items=new concessionItem[MAX_ITEMS];
        this.qtys=new int[MAX_ITEMS];
        this.itemCount=0;
        this.ticketCount=0;
    }

    public void addTicket(Ticket t){
        if(ticketCount<MAX_TICKETS){
            tickets[ticketCount]=t;
            ticketCount++;
        }
    }

    public void addItem(concessionItem c, int qty){
        if(qty<=0){
            return;
        } else if(itemCount<MAX_ITEMS) {
            items[itemCount]=c;
            qtys[itemCount]=qty;
            itemCount++;
        }
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
    public concessionItem[] getItems(){
        return items;
    }
    public int[] getQtys(){
        return qtys;
    }
    public int getItemCount(){
        return itemCount;
    }
    public double sumTicketsPaid(){
        double sum=0.0;
        for(int i=0;i<ticketCount;i++){
            sum+=tickets[i].getPricePaid();
        }
        return sum;
    }

    public double sumConcessionRaw(){
        double sum=0;

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
}
