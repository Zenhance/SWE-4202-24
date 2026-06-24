package model;

public class PremiumTicket extends AbstractTicket {

    public PremiumTicket(Showtime showtime, int row, int col){
        super(showtime,row,col);
    }

    @Override
    public double subtotal() {
        double res = base*1.30;
        if (showtime.isPeak()) res = res*peak;
        return res;
    }

    @Override
    public String describe(){
        return "vipticket+premiumticket";
    }

}