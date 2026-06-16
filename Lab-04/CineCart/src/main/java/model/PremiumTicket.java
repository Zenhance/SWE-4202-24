package model;

public class PremiumTicket extends Ticket{

    public PremiumTicket(Showtime showtime, int row, int col, double basePrice, double peak) {
        super(showtime, row, col, basePrice, peak);
    }

    @Override
    public double getCharge() {
        if (showtime.isPeak())
            return basePrice *peak*1.3;
        else return basePrice *1.3;
    }
}
