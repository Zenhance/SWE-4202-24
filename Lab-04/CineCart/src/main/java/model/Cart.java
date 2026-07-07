package model;

public class Cart {
public static final int MAX_TICKETS=20;
public static final int MAX_ITEMS=20;
private Customer owner;
private Ticket[] tickets;
private int ticketCount;
private int itemCount;
private ConcessionItem[] items;
private int[] qtys;
private LineItem[] lines;
private int count;
    public double sumConcessionsRaw() {
        double sum = 0;

        for (int i = 0; i < itemCount; i++) {
            sum += items[i].getUnitPrice() * qtys[i];
        }

        return sum;
    }
public Cart(Customer owner){
    this.owner=owner;
    lines=new LineItem[100];
    tickets=new Ticket[MAX_TICKETS];
    items=new ConcessionItem[MAX_ITEMS];
    qtys=new int[MAX_ITEMS];
    ticketCount=0;
    itemCount=0;
    count =0;
}
public void add(LineItem line){
        lines[count++]=line;
}
    public void add(ConcessionItem item,int qty){
    add(new ConcessionLine(item,qty));
    }
    public void add(ConcessionItem item,int qty){
        add(new ConcessionLine(item,1));
      }
      public LineItem[] getLines(){
        LineItem[] copy=new LineItem[count];
        for(int i=0;i<count;i++){
            copy[i]=lines[i];
        }
        return copy;
      }
      public double grandSubtotal(){
        double total=0;
        for(int i=0;i<count;i++){
            total+=lines[i].subtotal();
        }
        return total;
    }
    public int ticketCount(){
        int tickets=0;
        for(int i=0;i<count;i++){
        if(lines[i].isTicket()){
            tickets++;
        }
        }
        return tickets;
    }
    public boolean hasCode(String code){
        for(int i=0;i<count;i++) {
            if(lines[i].hasCode(code)){
                return true;
        }
        }
        return false;
    }

    public void addTicket(Ticket t){
    if(ticketCount<MAX_TICKETS){
        tickets[ticketCount]=t;
        ticketCount++;
    }
}
public void addItem(ConcessionItem c, int qty){
    if(itemCount<MAX_ITEMS && qty>0){
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
    double sum=0;
    for(int i=0;i<ticketCount;i++){
        sum+=tickets[i].getPricePaid();
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
