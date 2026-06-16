package model;

public class PremiumTicket extends AbstractTicket{
    public PremiumTicket(Showtime base, int row, int col){
        super(base, row, col);
    }
    @Override
    public double subtotal(){
        return applyPeak(getBasePrice()*1.30);
    }
    @Override
    public String describe(){
        return "Premium Ticket";
    }
}
