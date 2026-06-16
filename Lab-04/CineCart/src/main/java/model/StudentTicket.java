package model;

public class StudentTicket extends Ticket{
    public StudentTicket(Showtime showtime,int row,int col,double basePrice){
        super(showtime,row,col,basePrice);
    }

    public double subtotal(){
        return basePrice * 0.50 * peakMultiplier();
    }

    public String describe(){
        return "Student Ticket R" + row + "C" + col;
    }
}
