package model;

public class StandardTicket extends Ticket{

    double peak = 1.20;

    public StandardTicket(Showtime showtime, int row, int col, double pricePaid, double peak){
        super(showtime, row, col, pricePaid);
        this.peak = peak;
    }

    @Override
    public double getCharge() {
        if (showtime.isPeak())
            return pricePaid*peak;

        else return pricePaid;
    }
}
