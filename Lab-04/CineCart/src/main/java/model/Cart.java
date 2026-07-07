package model;

public class Cart {
    public static final int MAX_LINES = 40;

    private final Customer owner;
    private final LineItem[] lines;
    private  int lineCount;

    public Cart(Customer owner){
        this.owner = owner;
        lines = new LineItem[MAX_LINES];
        lineCount = 0;
    }

    public Customer getOwner() {
        return owner;
    }

    public LineItem[] getLines() {
        return lines;
    }

    public int getLineCount(){
        return lineCount;
    }

    public void add(LineItem l){
        if (lineCount >= MAX_LINES)
            throw new IllegalArgumentException("MAX LINES exceeded");
        lines[lineCount] = l;
        lineCount++;
    }

    public double grandSubtotal(){return 0;}



/*
    public void addTicket(AbstractTicket t){
        if (lineCount >= MAX_LINES)
            throw new IllegalArgumentException("MAX LINES exceeded");
        lines[lineCount] = t;
        lineCount++;
    }

    public void addItem(ConcessionLine c, int qty){
        if (lineCount >= MAX_LINES || qty <= 0 || (lineCount+qty) >= MAX_LINES)
            throw new IllegalArgumentException("MAX LINES exceeded OR Qty is too low");
        lines[lineCount] = c;
        //qtys[lineCount] = qty;
        lineCount++;
    }

    public double sumTicketsPaid(){
        double ticketPrice = 0;
        for(int i = 0; i < ticketCount; i++){
            ticketPrice += tickets[i].getPricePaid();
        }
        return ticketPrice;
    }

    public double sumConcessionsRaw(){
        double conPrice = 0;
        for(int i = 0; i < itemCount; i++){
            conPrice += items[i].getUnitPrice() * qtys[i];
        }
        return conPrice;
    }

    public boolean hasItem(String code){

        for(int i = 0; i < itemCount; i++){
            ConcessionItem it = items[i];
            if(code.equals(it.getCode())) return true;
        }
        return false;
    }*/

    public boolean hasCode(String c){
        return false;
    }
}
