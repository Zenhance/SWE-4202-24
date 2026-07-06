package model;

public class VIPTicket extends PremiumTicket{
    VIPTicket(Showtime showtime, int row, int col){
        super(showtime, row, col);
    }

    public double subtotal() {
        return super.subtotal() + 200.00;
    }

}
