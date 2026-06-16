package model;

public class StudentTicket extends AbstractTicket{
    public StudentTicket(Showtime id, int row, int col) {
        super(id, row, col);
    }

    @Override
    public String describe() {
        return "";
    }
}
