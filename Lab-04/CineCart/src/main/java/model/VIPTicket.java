package model;

public class VIPTicket extends PremiumTicket {


    public VIPTicket(Showtime showtime, int row, int col) {

        super(showtime,row,col);
    }

    @Override
    public double subtotal() {
        return base+200.0;
    }

    @Override
    public String describe(){
        return "vipticket";
    }
}
