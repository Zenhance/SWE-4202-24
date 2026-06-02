package model;

public class Cart {
    public static final int MAX_TICKETS=20;
    public static final int MAX_ITEMS=20;


    private Customer owner;
    private Ticket[] tickets;
    private int ticketCount;
    private ConcessionItem[] items;
    private int[] qtys;
    private int itemCount;

    public Cart(Customer owner){
        this.owner = owner;
        this.tickets = new Ticket[MAX_TICKETS];
        this.items = new ConcessionItem[MAX_ITEMS];
        this.qtys = new int[MAX_ITEMS];
        this.ticketCount = 0;
        this.itemCount = 0;
    }
    public void addTicket(Ticket t) {
        if (ticketCount >= 20) {
            return;

        }
        tickets[ticketCount] = t;
        ticketCount++;

    }

    public void addItem(ConcessionItem c, int qty){
        if(itemCount>=20){
            return;
        }
        if(qty<=20){
            return;
        }
        items[itemCount]=c;
        qtys[itemCount]=qty;
        itemCount++;

    }



    public Customer getOwner()
    { return owner;
    }
    public Ticket[] getTickets()        {
        return tickets; }
    public int getTicketCount()         {
        return ticketCount; }
    public ConcessionItem[] getItems()  {
        return items; }
    public int[] getQtys()              {
        return qtys; }
    public int getItemCount()           {
        return itemCount; }


    public double sumTicketsPaid(){
        double total=0;
        for(int i=0;i<itemCount;i++){
            total+=tickets[i].getPricePaid();

        }
        return total;
    }

    public double sumConcessionsRaw(){
        double total=0;
        for(int i=0;i<itemCount;i++){
            total+=items[i].getUnitPrice()*qtys[i];

        }
        return total;
    }

    public boolean hasItem(String code){
        for(int i=0;i<itemCount;i++){
            if (items[i].getCode().equals(code)) return true;
        }
        return false;
        }

    }












