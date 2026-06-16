package model;

public class PremiumTicket extends AbstractTicket{
    public PremiumTicket(Showtime showtime,int col ,int row){
        super(showtime,col,row);
    }
    @Override
    public double subtotal(){
        return (basePrice*1.3)*getPeakMultiplier();
    }
    @Override
    public String describe(){
        return super.describe()+"Premium Ticket";
    }

}
