package model;

public class StudentTicket extends Ticket{
    public StudentTicket(Showtime showtime, int row, int col){
        super(showtime, row, col);
    }

    @Override
    public double subtotal(){
        return basePrice*0.50*peakMultiplier();
    }

    @Override
    public String describe(){
        return super.describe() + " (Student)";
    }
}
