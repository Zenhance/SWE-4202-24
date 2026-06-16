package model;

public class PremiumTicket extends AbstractTicket{
    public PremiumTicket(Showtime showtime, int row, int col) {
        super(showtime, row, col);
    }
    @Override
    public double subtotal() {
        return basePrice*1.30*peak();
    }
    @Override
    public String describe(){
        return "Premium Ticket";
    }
}
