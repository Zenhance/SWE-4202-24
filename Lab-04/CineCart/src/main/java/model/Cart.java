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
         items = new ConcessionItem[MAX_ITEMS];
        qtys = new int[MAX_ITEMS];
        count = 0;
        itemCount = 0;
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
        if(itemCount < MAX_TICKETS){
            ConcessionLine l = new ConcessionLine(c, qty);
            items[itemCount] = c;
            lineItems[count] = l;
            qtys[itemCount] = qty;
            count++;
            itemCount++;
            res = true;
        }
        return res;
    }

    public boolean add(ConcessionItem c){
        if (count >= MAX_TICKETS+MAX_ITEMS) return false;

        ConcessionLine l = new ConcessionLine(c, 1);
        items[itemCount] = c;
        lineItems[count] = l;
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

    public boolean add(ComboLine L){
        if (count >= MAX_ITEMS+MAX_TICKETS) return false;
        lineItems[count] = L;
        count++;
        items[itemCount] = L.getA();
        itemCount++;
        items[itemCount] = L.getB();
        itemCount++;
        return true;

    }

    public boolean add(ConcessionLine L){
        if (count >= MAX_ITEMS+MAX_TICKETS) return false;
        lineItems[count] = L;
        count++;
        items[itemCount] = L.getItem();
        itemCount++;
        return true;

    }

    public boolean add(ConcessionItem A, ConcessionItem B){
        if (count+1 >= MAX_ITEMS+MAX_TICKETS) return false;
        LineItem l = new ComboLine(A, B);
        lineItems[count] = l;
        items[itemCount] = A;
        itemCount++;
        items[itemCount] = B;
        count++;
        return true;
    }



    public LineItem[] getLines() {
        LineItem[] l = new LineItem[count];
        for (int i = 0; i < count; i++)
        {
            l[i] = lineItems[i];
        }
        return l;
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
                return true;
            }
        }
        return found;
    }

    public int ticketCount(){
        int res = 0;
        for (int i = 0; i < count; i++)
        {
            if(lineItems[i].isTicket()) res++;
        }
        return res;
    }
}
