package model;

public class Cart {
    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;

    private final Customer owner;
    private final Ticket[] tickets;
    private int ticketCount;
    private final ConcessionItem[] items;
    private final int[] qtys;
    private int itemCount;

    public Cart(Customer owner) {
        this.owner = owner;
        this.tickets = new Ticket[MAX_TICKETS];
        this.items = new ConcessionItem[MAX_ITEMS];
        this.ticketCount = 0;
        this.itemCount = 0;
        this.qtys = new int[MAX_ITEMS];
    }
    public boolean addTicket(Ticket t){
        if (ticketCount >= MAX_TICKETS) return false;
        tickets[ticketCount++] = t;
        return true;
    }

    public boolean addItem(ConcessionItem c, int qty){
        if (qty <= 0 || itemCount >= MAX_ITEMS) return false;
        items[itemCount] = c;
        qtys[itemCount] = qty;
        itemCount++;
        return true;
    }

    public Customer getOwner() {
        return owner;
    }


    public Ticket[] getTickets() {
            Ticket[] snapshot = new Ticket[ticketCount];
            for (int i = 0; i < ticketCount; i++) {
                snapshot[i] = tickets[i];
            }
            return snapshot;
        }



    public int getTicketCount() {
        return ticketCount;
    }


    public ConcessionItem[] getItems() {
            ConcessionItem[] snapshot = new ConcessionItem[itemCount];
            for (int i = 0; i < itemCount; i++) {
                snapshot[i] = items[i];
            }
            return snapshot;
        }


        public int[] getQtys() {
            int[] snapshot = new int[itemCount];
            for (int i = 0; i < itemCount; i++) {
                snapshot[i] = qtys[i];
            }
            return snapshot;
        }



    public int getItemCount() {
        return itemCount;
    }

    public double sumTicketsPaid(){
        int sum = 0;
        for(int i = 0; i < ticketCount; i++){
            sum += tickets[i].getPricePaid();
        }
        return sum;
    }

    public double sumConcessionsRaw(){
        int sum = 0;
        for(int i = 0; i < itemCount; i++){
            sum += (items[i].getUnitPrice() * qtys[i]);
        }
        return sum;
    }

    public boolean hasItem(String code){
        for(int i = 0; i < itemCount; i++){
            if(items[i].getCode().equals(code)){
                return true;
            }
        }
        return false;
    }




}