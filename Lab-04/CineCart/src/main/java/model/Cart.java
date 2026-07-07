package model;

public class Cart {

    public static final int MAX_LINES = 40;

    private final Customer owner;
    private final LineItem[] lines;
    private int count;

    public Cart(Customer owner) {
        this.owner = owner;
        this.lines = new LineItem[MAX_LINES];
        this.count = 0;
    }


    public void add(LineItem line) {
             if(count < lines.length){
                 lines[count]=line;
             }
    }


    public void add(ConcessionItem item, int qty) {
         add(new ConcessionLine(item,qty));
    }

    public void add(ConcessionItem item) {
        add(item,1);
            }

    public LineItem[] getLines() {

        return lines;
    }

    public double grandSubtotal() {

        return 0;
    }

    public int ticketCount() {

        return 1;
    }

    public boolean hasCode(String code) {
    return false;
    }

    public Customer getOwner() {
        return owner;
    }
}