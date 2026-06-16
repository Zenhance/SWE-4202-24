package model;

public class Cart {
    public static  final int MAX_TICKETS = 20;
    public static  final int MAX_ITEMS = 20;

    private final Customer owner;
    private final Ticket[] tickets;
    private int ticketCount;
    private final ConcessionItem[] items;
    private final int[] qtys;
    private int itemCount;
    private final LineItem[] lines;
    private int lineCount;

    public Cart(Customer owner){
        this.owner = owner;
        this.tickets = new Ticket[MAX_ITEMS];
        this.ticketCount = 0;
        this.items = new ConcessionItem[MAX_ITEMS];
        this.qtys = new int[MAX_ITEMS];
        this.itemCount = 0;
        this.lines = new LineItem[MAX_TICKETS+MAX_ITEMS];
        this.lineCount = 0;
    }
    public boolean addItem(ConcessionItem c, int qty) {
        if (itemCount >= MAX_ITEMS || qty <= 0) {return false;}
            qtys[itemCount] = qty;
            items[itemCount]=c;
            itemCount++;
            return true;
        }

    public boolean addTicket(Ticket t) {
        if(ticketCount>=MAX_TICKETS){
            return false;}
            tickets[ticketCount]=t;
            ticketCount++;
            return true;
        }


       public Customer getOwner() {
            return owner;
        }
       public Ticket[] getTickets(){
           return tickets;
        }
       public int getTicketCount(){
           return ticketCount;
        }
       public ConcessionItem[] getItems(){
           return items;
        }
       public int[] getQtys(){
           return qtys;
        }
       public int getItemCount() {
       return itemCount;
       }
       public double sumTicketsPaid(){
           double sum = 0.0;
           for(int i = 0; i<ticketCount ; i++){
               sum+=tickets[i].getPricePaid();
           }
           return sum;
        }
        public double sumConcessionsRaw(){
        double sum = 0.0;
        for(int i=0;i<itemCount;i++){
            if(items[i]!=null){
            sum+=items[i].getUnitPrice()*qtys[i];}
        }
        return sum;
        }
        public boolean hasItem(String code){
        for(int i=0;i<itemCount;i++){
            if(items[i]!=null&&items[i].getCode().equals(code)){
                return true;
            }
        }
        return false;
        }
        public boolean add(LineItem line){
        if(lineCount>=lines.length){
            return false;
        }
        lines[lineCount] =line;
        lineCount++;
        return true;
        }
        public boolean add(ConcessionItem item,int qty){
        if(qty<=0){return false;}
        return add(new ConcessionLine(item,qty));
        }
        public boolean add(ConcessionItem item){
        return add(item,1);
        }
        public LineItem[] getLines(){
        LineItem[] copy = new LineItem[lineCount];
        for(int i=0; i<lineCount;i++){
            copy[i] = lines[i];
        }
        return copy;
        }
        public double grandSubtotal(){
        double total = 0;
        for(int i=0;i<lineCount;i++){
            total+=lines[i].subtotal();
            }
        return total;
        }
        public int ticketCount() {
            int total = 0;
            for (int i = 0; i < lineCount; i++) {
                if (lines[i].isTicket()) {
                    total++;
                }
            }
            return total;
        }
        public  boolean hasCode(String code){
        for(int i=0; i < lineCount; i++){
            if(lines[i].hasCode(code)){
                return true;
            }
        }
        return false;
        }
}
