package model;

public class PremiumTicket extends Ticket{

    public PremiumTicket(Showtime showtime, int row, int col, double pricePaid, double peak) {
        super(showtime, row, col, pricePaid, peak);
    }

    @Override
    public double getCharge() {
        if (showtime.isPeak())
            return pricePaid*peak*1.3;
        else return pricePaid*1.3;
    }
}
