package model;

public class StudentTicket extends AbstractTicket {
    public StudentTicket(Showtime showtime, int row, int col) {
        super(showtime, row, col);
    }

    @Override
    public double subtotal() {
        return calculateBase() * 0.50;
    }

    @Override
    public String describe() {
        return super.describe() + " (Student Discount)";
    }
}
