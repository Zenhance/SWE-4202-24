package model;

public class StudentTicket extends StandardTicket {
    public StudentTicket(Showtime showtime, int row, int col){
        super(showtime,row,col);
    }

    public double subtotal() {
        return 0;
    }

    public String describe() {
        return null;
    }
}
