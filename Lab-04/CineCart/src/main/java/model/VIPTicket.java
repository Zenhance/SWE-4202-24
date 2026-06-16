package model;

public class VIPTicket extends PremiumTicket {

    public VIPTicket(Showtime showtime, int row, int col, double basePrice, double peak) {
        super(showtime, row, col, basePrice, peak);
    }

    @Override
    public double getCharge() {
        return super.getCharge() + 200.00;
    }
}
