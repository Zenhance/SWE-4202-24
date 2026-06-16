package model;

public class StandardTicket extends AbstractTicket{


    public StandardTicket(Showtime showtime, int row, int col, double pricePaid) {
        super(showtime, row, col, pricePaid);
    }

    @Override
    public double Subtotal() {
        return 0;
    }

    @Override
    public String describe() {
        return "";
    }
}
