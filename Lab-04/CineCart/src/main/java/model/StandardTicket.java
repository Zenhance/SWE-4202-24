package model;

public class StandardTicket extends Ticket{


    public StandardTicket(Showtime showtime, int row, int col, double basePrice, double peak){
        super(showtime, row, col, basePrice, peak);

    }

    @Override
    public double getCharge() {

        if (showtime.isPeak())
            return basePrice *peak;

        else return basePrice;
    }
}
