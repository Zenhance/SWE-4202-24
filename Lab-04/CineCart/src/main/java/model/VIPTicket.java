package model;

public class VIPTicket extends Ticket {

    public VIPTicket(Showtime showtime, int row, int col, double pricePaid, double peak) {
        super(showtime, row, col, pricePaid, peak);
    }

    @Override
    public double getCharge() {
        if (showtime.isPeak())
            return pricePaid*peak*1.3 + 200.00;

        else return pricePaid*1.3 + 200.00;
    }
}
