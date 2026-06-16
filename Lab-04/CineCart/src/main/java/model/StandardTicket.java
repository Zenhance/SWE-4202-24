package model;

public class StandardTicket extends Ticket{


    public StandardTicket(Showtime showtime, int row, int col, double pricePaid, double peak){
        super(showtime, row, col, pricePaid, peak);

    }

    @Override
    public double getCharge() {
        if (showtime.isPeak())
            return pricePaid*peak;

        else return pricePaid;
    }
}
