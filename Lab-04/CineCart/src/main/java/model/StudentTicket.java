package model;

public class StudentTicket extends AbstractTicket {
    public StudentTicket(Showtime showtime, int row, int col){
        super(showtime,row,col);
    }

    public double subtotal(){
        double basePrice
        return basePrice * 0.50 * peak();
    }

    public String describe(){
        return "Student Ticket";
    }
}
