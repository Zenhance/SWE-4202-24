package model;

public class PremiumTicket extends Ticket {
    public PremiumTicket(Showtime showtime,int row,int col){
        super(showtime,row,col);
    }
    @Override
    public double subtotal(){
        return base*PeakTime()*1.30;
    }
}
