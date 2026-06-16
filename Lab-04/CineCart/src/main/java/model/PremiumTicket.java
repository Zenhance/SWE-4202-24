package model;

public class PremiumTicket extends AbstractTicket{


    public PremiumTicket(Showtime showtime, int row, int col, double pricePaid) {
        super(showtime, row, col, pricePaid);
    }

    @Override
    public double Subtotal() {
        return 0;
    }

    public String describe(){


        return "";
    }
}
