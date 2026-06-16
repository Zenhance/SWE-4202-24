package model;

public class Cart {
    public static final int MAX_TICKETS=20,MAX_ITEMS=20;
    private final Customer owner;
    private final Ticket[] tickets;
    public int ticketCount;
    private final ConcessionItem[] items;
    private final int[] qtys;
    private int itemCount;

    public Cart(Customer owner){
        this.owner=owner;
        tickets=new Ticket[MAX_TICKETS];
        items=new ConcessionItem[MAX_ITEMS];
        qtys=new int[MAX_ITEMS];
        ticketCount=0;
        itemCount=0;
    }
    public boolean addTicket(Ticket t){
        if (ticketCount<MAX_TICKETS){
            tickets[ticketCount]=t;
            ticketCount++;
            return true;
        }
        return false;

    }
    public boolean addItem(ConcessionItem c,int qty)
        {
            if (itemCount<MAX_ITEMS && qty>0)
            {
                items[itemCount]=c;
                qtys[itemCount]=qty;
                itemCount++;
                return true;
            }
            return false;
        }

    public Customer getOwner(){
        return owner;
    }

    public int getItemCount(){
        return itemCount;
    }

    public int getTicketCount(){
        return ticketCount;
    }
    public int[] getQtys(){
        int[] copy= new int[itemCount];
        for(int i=0;i<itemCount;i++)
        {
            copy[i]=this.qtys[i];
        }
        return  copy ;
    }
    public Ticket[] getTickets(){
        Ticket[] copy= new Ticket[ticketCount];
        for(int i=0;i<ticketCount;i++)
        {
            copy[i]=this.tickets[i];
        }
        return  copy ;
    }

    public ConcessionItem[] getItems(){
        ConcessionItem[] copy= new ConcessionItem[itemCount];
        for(int i=0;i<itemCount;i++)
        {
            copy[i]=this.items[i];
        }
        return  copy ;
    }

    public double sumTicketsPaid(){
        double sum=0;
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
    public boolean hasItem(String code) {
        for( int i=0;i<itemCount;i++){
        if(items[i].getCode().equals(code))
            return true;
        }
        return false;
    }

    public void add(PremiumTicket premiumTicket) {

    }

    public void add(ConcessionItem pop, int i) {

    }

    public boolean hasCode(String soda) {

        return false;
    }

    public void add(ComboLine comboLine) {

    }

    public void add(ConcessionLine concessionLine) {

    }

    public void add(StudentTicket studentTicket) {
    }

    public void add(StandardTicket standardTicket) {

    }

    public double grandSubtotal() {
        return 0;
    }

    public LineItem[] getLines() {

        return null;
    }

    public int ticketCount() {

        return 0;
    }
}
