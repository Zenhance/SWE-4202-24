package model;

public class StudentTicket extends AbstractTicket{
    public StudentTicket(Showtime id, int row, int col) {
        super(id, row, col);
    }

    @Override
    public double subtotal() {
        return 450;
    }

    @Override
    public String describe() {
        return "lounge";
    }
}
