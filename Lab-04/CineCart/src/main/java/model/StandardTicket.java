package model;

public class StandardTicket extends AbstractTicket{
    public PremiumTicket(Showtime showtime,int row ,int col){
        super(showtime,row,col);
    }
    @Override
    public double subtotal(){
        return basePrice*1*getPeakMultiplier();
    }
    @Override
    public String describe(){
        return super.describe()+" Standard Ticket";
    }

}
}
