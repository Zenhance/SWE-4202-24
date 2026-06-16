package model;

public class PremiumTicket extends AbstractTicket{


    public PremiumTicket(Showtime id, int row, int col) {
        super(id, row, col);
    }
    public double subtotal(){

        return 0;
    }

    @Override
    public String describe() {
        return "";
    }

}
