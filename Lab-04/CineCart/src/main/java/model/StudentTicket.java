
package model;

public class StudentTicket extends Ticket {

    public static final double STUDENT_MULTIPLIER = 0.50;

    public StudentTicket(Showtime showtime, int row, int col) {
        super(showtime, row, col);
    }

    @Override
    public double subtotal() {
        return base * STUDENT_MULTIPLIER * peakFactor();
    }

    @Override
    public String describe() {
        return super.describe() + " (Student Concession)";
    }
}
 