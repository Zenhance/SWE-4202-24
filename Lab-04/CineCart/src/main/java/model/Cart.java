package model;

public class Cart {
    public static final int MAX_TICKETS = 20;
    public static final int MAX_ITEMS = 20;
    private static final int MAX_LINES = MAX_TICKETS + MAX_ITEMS;

    private Customer owner;
    private LineItem[] lines;
    private int lineCount;

    public Cart(Customer owner) {
        this.owner = owner;
        this.lines = new LineItem[MAX_LINES];
        this.lineCount = 0;
    }

    public Customer getOwner() {
        return owner;
    }

    public void add(LineItem line) {
        if (lineCount < MAX_LINES && line != null) {
            lines[lineCount] = line;
            lineCount++;
        }
    }

    public void add(ConcessionItem item, int qty) {
        if (qty > 0) {
            add(new ConcessionLine(item, qty));
        }
    }

    public void add(ConcessionItem item) {
        add(item, 1);
    }

    public void addTicket(Ticket t) {
        add(t);
    }

    public void addItem(ConcessionItem c, int qty) {
        add(c, qty);
    }

    public LineItem[] getLines() {
        LineItem[] copy = new LineItem[lineCount];

        for (int i = 0; i < lineCount; i++) {
            copy[i] = lines[i];
        }

        return copy;
    }

    public double grandSubtotal() {
        double total = 0.0;

        for (int i = 0; i < lineCount; i++) {
            total += lines[i].subtotal();
        }

        return total;
    }

    public int ticketCount() {
        int count = 0;

        for (int i = 0; i < lineCount; i++) {
            if (lines[i].isTicketLine()) {
                count++;
            }
        }

        return count;
    }

    public boolean hasCode(String code) {
        for (int i = 0; i < lineCount; i++) {
            if (lines[i].carriesCode(code)) {
                return true;
            }
        }

        return false;
    }

    public Ticket[] getTickets() {
        Ticket[] result = new Ticket[ticketCount()];
        int idx = 0;

        for (int i = 0; i < lineCount; i++) {
            if (lines[i].isTicketLine()) {
                result[idx] = (Ticket) lines[i];
                idx++;
            }
        }

        return result;
    }

    public int getTicketCount() {
        return ticketCount();
    }

    public ConcessionItem[] getItems() {
        int count = getItemCount();
        ConcessionItem[] result = new ConcessionItem[count];
        int idx = 0;

        for (int i = 0; i < lineCount; i++) {
            if (lines[i] instanceof ConcessionLine) {
                result[idx] = ((ConcessionLine) lines[i]).getItem();
                idx++;
            }
        }

        return result;
    }

    public int[] getQtys() {
        int count = getItemCount();
        int[] result = new int[count];
        int idx = 0;

        for (int i = 0; i < lineCount; i++) {
            if (lines[i] instanceof ConcessionLine) {
                result[idx] = ((ConcessionLine) lines[i]).getQty();
                idx++;
            }
        }

        return result;
    }

    public int getItemCount() {
        int count = 0;

        for (int i = 0; i < lineCount; i++) {
            if (lines[i] instanceof ConcessionLine) {
                count++;
            }
        }

        return count;
    }

    public double sumTicketsPaid() {
        double total = 0.0;

        for (int i = 0; i < lineCount; i++) {
            if (lines[i].isTicketLine()) {
                total += lines[i].subtotal();
            }
        }

        return total;
    }

    public double sumConcessionsRaw() {
        double total = 0.0;

        for (int i = 0; i < lineCount; i++) {
            if (!lines[i].isTicketLine()) {
                total += lines[i].subtotal();
            }
        }

        return total;
    }

    public boolean hasItem(String code) {
        return hasCode(code);
    }
}