package model;

public class StudentTicket extends AbstractTicket{
    StudentTicket(Showtime showtime,int row ,int col){
        super(showtime,row,col);
    }
    public double subtotal(){
        return basePrice*0.50*peak();
    }
    public String describe(){
        return "Student Ticket";
    }
}
