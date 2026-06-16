package model;

public class StudentTicket extends StandardTicket{
    public StudentTicket(Showtime showtime, int row, int col){
        super(showtime,row,col);
    }
    @Override
    public double subtotal(){
        return base*0.50*peakMultiplier();
    }
    @Override
    public String describe(){
        return super.describe()+" Standard";
    }
}
