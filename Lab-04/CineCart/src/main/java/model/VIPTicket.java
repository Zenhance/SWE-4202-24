package model;

public class VIPTicket extends PremiumTicket{
    public VIPTicket(Showtime showtime, int row, int col, double pricePaid) {
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
