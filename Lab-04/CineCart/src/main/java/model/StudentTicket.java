package model;

public class StudentTicket extends AbstractTicket{

    public StudentTicket(Showtime showtime, int i, int i1) {
        super(showtime, i, i1);
    }

    public double subtotal() {
        return 0.0d;
    }

    public String describe() {
        return " ";
    }
}
