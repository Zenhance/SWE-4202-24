package model;

public class Cart {
    public static final int MAX_TICKET = 20;
    public static final int MAX_ITEMS = 20;
    public static final int MAX_LINES=50;

    private Customer owner;
    private Ticket[] tickets;
    private int ticketCount;
    private ConcessionItem[] items;
    private int[] qtys;
    private int itemCount;
    private LineItem[] lines;
    private int lineCount;

    public Cart(Customer owner) {
        this.owner = owner;
        this.tickets = new Ticket[MAX_TICKET];
        this.ticketCount = 0;
        this.items = new ConcessionItem[MAX_ITEMS];
        this.qtys = new int[MAX_ITEMS];
        this.itemCount = 0;
        this.lines=new LineItem[MAX_LINES];
        this.lineCount=0;
    }

    public void addTicket(Ticket t) {
        if (ticketCount < MAX_TICKET) {
            tickets[ticketCount] = t;
            ticketCount++;
        }
    }

    public void addItem(ConcessionItem c, int qty) {
        if (itemCount < MAX_ITEMS && qty > 0) {
            items[itemCount] = c;
            qtys[itemCount] = qty;
            itemCount++;

            add(new ConcessionLine(c,qty));
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

    public double sumTicketsPaid() {
        double total = 0.0;

        for (int i = 0; i < ticketCount; i++) {
            total += tickets[i].getPricePaid();
        }
        return total;
    }

    public double sumConcessionRaw() {
        double total = 0.0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getUnitPrice() * qtys[i];
        }
        return total;
    }

    public boolean hasItem(String code) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }
    public void add(ConcessionItem item){
        add(item,1);
    }
    public void add(ConcessionItem item,int qty){
        if(qty>0){
            add(new ConcessionLine(item,qty));
        }
    }
    public LineItem[] getLines(){
        LineItem[] copy=new LineItem[lineCount];
        for(int i=0;i<lineCount;i++){
            copy[i]=lines[i];
        }
        return copy;
    }

    public double grandSubTotal(){
        double total=0.0;
        for(int i=0;i<lineCount;i++){
            total+=lines[i].subtotal();
            }
        return total;
        }

        public int ticketCount(){
        int count=0;
        for(int i=0;i<lineCount;i++){
            if(lines[i].isTicket()){
                count++;
            }
        }
        return count;
        }

        public boolean hasCode(String code){
        for(int i=0;i<lineCount;i++){
            if(lines[i].hasCode(code)){
                return true;
            }
        }
        return false;
        }
        public void add(LineItem line){
        if(lineCount<MAX_LINES && line!=null){
            lines[lineCount]=line;
            lineCount++;
        }
        }
    }






