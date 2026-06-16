package model;

public class StudentTicket extends Ticket{

    public StudentTicket(Showtime showtime, int row, int col, double pricePaid, double peak){
        super(showtime, row, col, pricePaid, peak);

    }

    @Override
    public double getCharge() {
        if (showtime.isPeak())
            return pricePaid*0.5*peak;
        else return pricePaid*0.5;
    }
}
