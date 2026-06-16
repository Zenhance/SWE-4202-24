package model;

public class VIPTicket extends PremiumTicket{
    public VIPTicket(Showtime showtime, int row, int col) {
        super(showtime, row, col);
    }
    @Override
    public double subtotal() {
        return (basePrice*1.50*peak())+200.0;
    }
    @Override
    public String describe(){
        return "VIP Ticket";
    }

}
