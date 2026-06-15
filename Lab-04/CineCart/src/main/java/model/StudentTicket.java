package model;

public class StudentTicket extends AbstractTicket {
    public StudentTicket(Showtime showtime, int row, int col){
        super(showtime, col, row);
    }
    public double subtotal(){
        return baseprice*0.50*peak();
    }
}
