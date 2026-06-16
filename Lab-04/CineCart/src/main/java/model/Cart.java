package model;

public class Cart {
//    public static final int MAX_TICKETS = 20;
//    public static final int MAX_ITEMS = 20;
    public static final int MAX_LINES=40;
    private Customer owner;
    private LineItem[] lines;
    private int count;
//    private int ticketCount;
//    private ConcessionItem[] items;
//    private int[] qtys;
//    private int itemCount;

    public Cart(Customer owner) {
        this.owner = owner;
        this.lines=new LineItem[MAX_LINES];
        this.count=0;
//        tickets = new Ticket[MAX_TICKETS];
//        items = new ConcessionItem[MAX_ITEMS];
//        qtys = new int[MAX_ITEMS];
//        ticketCount = 0;
//        itemCount = 0;
    }

    public boolean add(LineItem line){
        if(count>=MAX_LINES){
            return false;
        }
        lines[count]=line;
        count++;
        return true;
    }
    public boolean add(ConcessionItem item,int qty){
        if(qty<=0){
            return false;

        }
        else{
            return add(new ConcessionLine(item,qty));
        }
    }

    public boolean add(ConcessionItem item){
        return add(item,1);
    }
    public LineItem[] getLines(){
        LineItem[] copy=new LineItem[count];
        for(int i=0;i<count;i++){
            copy[i]=lines[i];

        }
        return copy;
    }
    public int getCount(){
        return count;
    }
    public double grandSubtotal(){
        double total=0.0;
        for(int i=0;i<count;i++){
            total+=lines[i].subtotal();
        }
        return total;
    }
    public int ticketCount(){
        int n=0;
        for(int i=0;i<count ;i++){
            if(lines[i] instanceof AbstractTicket){
                n++;
            }

        }
        return n;
    }
    public boolean hasCode(String code) {
        for (int i = 0; i < count; i++) {
            LineItem line = lines[i];
            if (line instanceof ConcessionLine) {
                if (((ConcessionLine) line).getItem().getCode().equals(code)) {
                    return true;
                } else if (line instanceof ComboLine) {
                    if (((ComboLine) line).containsCode(code)) {
                        return true;
                    }

                }
            }
        }
        return false;
    }


    public Customer getOwner() {
       return owner;
    }
//
//    public Ticket[] getTickets() {
//        return tickets;
//    }
//
//    public int getTicketCount() {
//        return ticketCount;
//    }
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
//
//    public void addTicket(Ticket t) {
//        if (ticketCount < MAX_TICKETS) {
//            tickets[ticketCount] = t;
//            ticketCount++;
//        }
//    }
//
//    public void addItem(ConcessionItem c, int qty) {
//        if (itemCount < MAX_ITEMS && qty > 0) {
//            items[itemCount] = c;
//            qtys[itemCount] = qty;
//            itemCount++;
//        }
//
//    }
//
//    public double sumTicketsPaid() {
//        double sum = 0;
//        for (int i = 0; i < ticketCount; i++) {
//            sum += tickets[i].getPricePaid();
//
//        }
//        return sum;
//    }
//
//    public double sumConcessionsRaw() {
//        double total = 0;
//        for (int i = 0; i < itemCount; i++) {
//            total += items[i].getUnitPrice() * qtys[i];
//        }
//        return total;
//    }
//
//    public boolean hasItem(String code) {
//        for (int i = 0; i < itemCount; i++) {
//            if (items[i].getCode().equals(code)) {
//                return true;
//            }
//
//
//
//        }
//        return false;
//    }

}
