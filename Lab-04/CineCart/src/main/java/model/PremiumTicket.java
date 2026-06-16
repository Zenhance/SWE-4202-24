package model;

public class PremiumTicket extends AbstractTicket{


    protected PremiumTicket(Showtime showtime, int row, int col) {
        super(showtime, row, col);
    }

    @Override
    public double subtotal() {
        return 0;
    }
    public String describe(){
        return super.describe()+"Premium Fare";
    }
}
