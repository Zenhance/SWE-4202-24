package model;

// A Ticket is created when a customer successfully books a seat.
// It records which showtime, which seat, and how much was charged.
public class Ticket {

    // --- Fields ---
    private Showtime showtime;  // which screening this ticket is for
    private int row;            // seat row
    private int col;            // seat column
    private double pricePaid;   // final price after all multipliers

    // --- Constructor ---
    public Ticket(Showtime showtime, int row, int col, double pricePaid) {
        this.showtime = showtime;
        this.row = row;
        this.col = col;
        this.pricePaid = pricePaid;
    }

    // --- Getters ---
    public Showtime getShowtime()   { return showtime; }
    public int getRow()             { return row; }
    public int getCol()             { return col; }
    public double getPricePaid()    { return pricePaid; }

    // Example: "T17 - R3C5 @ BDT 455.00"
    @Override
    public String toString() {
        return "T" + showtime.getId() +
                " - R" + row + "C" + col +
                " @ BDT " + String.format("%.2f", pricePaid);
    }
}
