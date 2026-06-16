package model;

public class Cart{
    public static final int MAX_LINES = 50;

    private Customer owner;
    private LineItem[] lines;
    private int lineCount;

    public Cart(Customer owner) {
        this.owner = owner;
        this.lines = new LineItem[MAX_LINES];
        this.lineCount = 0;
    }

    public void add(LineItem line) {
        if (lineCount >= MAX_LINES) {
            System.out.println("Cart is full.");
            return;
        }
        lines[lineCount] = line;
        lineCount++;
    }





    public Customer getOwner() {
        return owner;
    }

    public Ticket[] getTickets() {
        return tickets;
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

    public int getTicketCount() {
        return ticketCount;
    }





}