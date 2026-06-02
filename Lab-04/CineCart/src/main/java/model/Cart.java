package model;

public class Cart {
    public static final int MAX_TICKETS=20;
    public static final int MAX_ITEMS=20;
    private final ConcessionItem[] items;

    private Customer owner; //--> 'owner' will contain everything of the class "Customer"
    private Ticket[] tickets;
    private int ticketCount;
    private int[] qtys;
    private int itemCount;

    public Cart(Customer owner){
         this.tickets= new Ticket[ticketCount];
         this.items= new ConcessionItem[itemCount];
         this.ticketCount=0;
         this.itemCount=0;
    }


    public void addTicket(Ticket t){
         if(ticketCount<MAX_TICKETS){ //--> while use korsilam first e, but while use korle, same loop will be applicable to all other objects. but we dont want it.
             tickets[ticketCount]=t;
             ticketCount++;
         }
    }

   public void addItem(ConcessionItem c, int qty ){
        if(itemCount<MAX_ITEMS && qty>20){
            items[itemCount]=c;
            qtys[itemCount]=qty;

            itemCount++;
        }else{
            System.out.println("Cannot add more items");
        }
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
        double sum=0;
        for(int i=0; i<ticketCount; i++){
            sum+=tickets[i].getPricePaid(); /*So, basically, this thing will be applicable for every arrays
             in OOP. so, while calculating the total price, at first, we will need to get to the array
             where each of the tickets has been stored as a separate object. and since, those objetcs
             are private, you will need a getter (getpricePaid()) to access to these. */
        }
        return sum;
    }



    public double  sumConcessionRaw(){
        double sum_of_items=0;
        for(int i=0; i<itemCount;i++){
            sum_of_items+=(items[i].getUnitPrice()*(qtys[i]));
        }

        return sum_of_items;
    }

    public boolean  hasItem(String code){
        for(int i=0; i<itemCount; i++){
            return (items[i].getCode()).equals(code);
        }
        return false;
    }
}
