package model;

public class PremiumTicket extends AbstractTicket {
    public PremiumTicket(Showtime showtime,int row,int col){
        super(showtime, row, col);
    }

    @Override
    public double subtotal(){
        if (getShowtime().isPeak())
            return 350.00 * 0.50 * 1.20;
        else return 200.00 * 0.50;
    }

    @Override
    public String describe() {
        String string = String.format("Premium\n" +
                "subtotal : %f BDT", subtotal());
        return string;
    }
}
