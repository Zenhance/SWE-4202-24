package model;

public class StudentTicket {
    public StudentTicket(Showtime showtime,int row,int col){
        super(showtime,row,col);
    }
    public double subtotal(){
        return basePrice*0.50*peakMultiplier();
    }
    public String describe(){
        return "Student "+super.describe();
    }
}
