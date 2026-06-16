package model;

public class StudentTicket extends Ticket {

    public StudentTicket(Showtime showtime,
                         int row,
                         int col) {

        super(showtime, row, col);
    }


    public double subtotal() {
        return basePrice * 0.50 * peakMultiplier();
    }


    public String describe() {
        return super.describe() + " Student";
    }
}
