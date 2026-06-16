package model;

public class StudentTicket extends Ticket{
    public StudentTicket(Showtime showtime, int row, int col){
        super(showtime,row,col);
    }
    @Override
    public double subtotal(){
        return base*PeakTime()*0.50;
    }
}
