package model;

public class StudentTicket extends AbstractTicket {
    public StudentTicket(Showtime showtime,int row,int col){
        super(showtime,col,row);
    }
    @Override
    public double subtotal(){
        return basePrice*0.50*peak();
    }
    @Override
    public String describe(){
        return "Student Ticket";
    }
}
