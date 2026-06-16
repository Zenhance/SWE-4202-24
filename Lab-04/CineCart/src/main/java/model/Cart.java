package model;

public class Cart {
    //constants
    //public static final int MAX_TICKETS=20;
    //public static final int MAX_ITEMS=20;
    //fields
    private Customer owner;
    private LineItem[] lines;
    private int count;

    public Cart(Customer owner) {
        this.owner = owner;
        lines = new LineItem[100];
        count = 0;
    }

    public void add(LineItem line) {
        lines[count++] = line;
    }

    //overloading
    public void add(ConcessionItem item, int qty) {
        add(new ConcessionLine(item, qty));
    }

    //overloading
    public void add(ConcessionItem item) {
        add(new ConcessionLine(item, 1));
    }

    public LineItem[] getLines() {
        LineItem[] copy = new LineItem[count];
        for (int i = 0; i < count; i++) {
            copy[i] = lines[i];
        }
        return copy;
    }

    public double grandSubtotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total = total + lines[i].subtotal();
        }
        return total;
    }

    public int ticketCount() {
        int tickets = 0;
        for (int i = 0; i < count; i++) {
            if (lines[i].hasCode(code)) {
                return true;
            }
        }
        return false;
    }

    public Customer getOwner() {
        return owner;
    }
}



