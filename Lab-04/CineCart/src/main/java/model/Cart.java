package model;

public class Cart {
    public static  final int MAX_TICKETS = 20;
    public static  final int MAX_ITEMS = 20;

    private Customer owner;
    private Ticket[] tickets;
    private int ticketCount;
    private ConcessionItem[] items;
    private int[] qtys;
    private int itemCount;

    public Cart(Customer owner){
        this.owner = owner;
        this.tickets = new Ticket[MAX_ITEMS];
        this.ticketCount = 0;
        this.items = new ConcessionItem[MAX_ITEMS];
        this.qtys = new int[MAX_ITEMS];
        this.itemCount = 0;
    }
    public void addItem(ConcessionItem c, int qty){
       if(itemCount<MAX_ITEMS && qty>0) {
           qtys[itemCount] = qty;
           itemCount++;
       }
       public Customer getOwner() {
            return owner;
        }
       public Ticket[] getTicket{
           return tickets;
        }
}
