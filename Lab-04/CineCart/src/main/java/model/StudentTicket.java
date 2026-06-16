package model;

public class StudentTicket extends AbstractTicket{

    public StudentTicket(Showtime showtime, int row, int col) {
        super(showtime, row, col);
    }

    public double subtotal() {
        return getBase() * 0.50 * isPeak();
    }


}
