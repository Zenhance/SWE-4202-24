package model;

public class VIPTicket extends PremiumTicket{
    VIPTicket(Showtime showtime, int row, int col, double pricePaid){
        super(showtime, row, col, pricePaid);
    }

    public double getPricePaid() {
        return getPricePaid() + 200.00;
    }

}
