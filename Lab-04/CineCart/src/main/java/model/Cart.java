package model;

public class Cart {

    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;

    private Customer owner;
    LineItem[] lineItems;
    //private AbstractTicket[] tickets;
    private int ticketCount;
    private ConcessionItem[] items;
   private int[] qtys;
    private int count;
    private int itemCount;

    public Cart(Customer owner){
        this.owner = owner;
//        tickets = new AbstractTicket[MAX_TICKETS];
//        items = new ConcessionItem[MAX_ITEMS];
        //qtys = new int[MAX_ITEMS];
        count = 0;
        lineItems = new LineItem[MAX_TICKETS+MAX_ITEMS];
    }

//    public boolean addTicket(AbstractTicket t){
//        boolean res = false;
//        if (ticketCount < MAX_TICKETS){
//            tickets[ticketCount] = t;
//            ticketCount++;
//            res = true;
//        }
//        return res;
//    }
//
    public boolean add(ConcessionItem c, int qty){

        boolean res = false;
        int i = 0;
        if(itemCount < MAX_TICKETS && i < qty){
            items[itemCount] = c;
            qtys[itemCount] = qty;
            count++;
            itemCount++;
            res = true;
        }
        return res;
    }

    public boolean add(ConcessionItem c){
        if (itemCount >= MAX_TICKETS) return false;

        items[itemCount] = c;
        itemCount++;
        count++;
        return true;

    }

    public boolean add(LineItem L){
        if (count >= MAX_ITEMS+MAX_TICKETS) return false;

        lineItems[count] = L;
        count++;
        return true;

    }


    public LineItem[] getLines() {
        return lineItems;
    }

    //    public int getTicketCount() {
//        return ticketCount;
//    }
//    public AbstractTicket[] getTickets() {
//        return tickets;
//    }
//
    public Customer getOwner() {
        return owner;
    }
//
//    public ConcessionItem[] getItems() {
//        return items;
//    }
//
//    public int getItemCount() {
//        return itemCount;
//    }
//
//    public int[] getQtys() {
//        return qtys;
//    }

    public double grandSubtotal(){
        double sum = 0.0;
        for (int i = 0; i < count; i++){
            sum += lineItems[i].subtotal();
        }

        return sum;
    }

//    public double sumConcessionsRaw(){
//        double sum = 0.0;
//        for (int i = 0; i < itemCount; i++){
//            sum += items[i].getUnitPrice() * qtys[i];
//        }
//
//        return sum;
//    }

   public boolean hasCode(String code){

        boolean found = false;
        for (int i = 0; i < itemCount; i++){
            if(code.equals(items[i].getCode())){
                found = true;
                break;
            }
        }
        return found;
    }

    public int ticketCount(){
        return count - itemCount;
    }
}
