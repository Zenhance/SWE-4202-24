package model;

public class  Cart {

    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;

    private Customer owner;
    private LineItem[] lineItems;
     private AbstractTicket[] tickets;
    private int lineCount;
    private int ticketCount;
    private ConcessionItem[] items;
    private int[] qtys;
    private int itemCount;

    public Cart(Customer owner) {
        this.owner = owner;
        this.lineItems = new LineItem[MAX_ITEMS];
        //tickets = new Ticket[MAX_TICKETS];
        items = new ConcessionItem[MAX_ITEMS];
        qtys = new int[MAX_ITEMS];
        lineCount = 0;
    }



    public void add(LineItem a){
        if(lineCount>=MAX_ITEMS)return;;
        if(a == null) return;
        lineItems[lineCount++] =a ;

    }
}






   /*public boolean addTicket(AbstractTicket t) {

        boolean res = false;
        if (ticketCount < MAX_TICKETS) {
            tickets[ticketCount] = t;
            ticketCount++;
            res = true;
        }
        return res;
    }

    public boolean addItem(ConcessionItem c, int qty) {
        boolean res = false;
        if (itemCount < MAX_ITEMS) {
            items[itemCount] = c;
            qtys[itemCount] = qty;
            itemCount++;
            res = true;
        }
        return res;
    }  */

    /*

    public int getTicketCount() {
        return ticketCount;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public Customer getOwner() {
        return owner;
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

    public double sumTicketsPaid() {
        double sum = 0.0;
        for (int i = 0; i < ticketCount; i++) {
            sum += tickets[i].getPricePaid();
        }
        return sum;
    }

    public double sumConcessionsRaw() {
        double sum = 0.0;
        for (int i = 0; i < itemCount; i++) {
            sum += items[i].getUnitPrice() * qtys[i];
        }
        return sum;
    }

    public boolean hasItem(String code) {
        boolean found = false;
        for (int i = 0; i < itemCount; i++) {
            if (code.equals(items[i].getCode())) {
                found = true;
                break;
            }
        }
        return found;
    }
}
*/