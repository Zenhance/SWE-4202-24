package model;

public class StandardTicket extends AbstractTicket {

    public StandardTicket(Showtime showtime, int row, int seat) {
        super(showtime, row, seat);
    }

    @Override
    public double subtotal() {

        if (showtime.isPeak()) {
            return base * 1.20;
        }

        return base;
    }

    @Override
    public String describe() {
        return "Standard Ticket";
    }
}