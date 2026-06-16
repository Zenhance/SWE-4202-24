package model;

public class StudentTicket extends AbstractTicket {
    public StudentTicket(Showtime showtime,int row ,int col){
        super(showtime,row,col);
    }
    @Override
    public double subtotal(){
        return base*1*peakMultiplier();
    }
    @Override
    public String describe(){
        return "Standard Ticket";
    }

}
}
