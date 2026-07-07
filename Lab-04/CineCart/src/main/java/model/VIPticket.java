package model;

public class VIPticket extends PremiumTicket {
    public VIPticket(Showtime showtime, int row, int col){
        super(showtime,row,col);
    }

    @Override
    public double subTotal(){
        return super.subTotal()+200;

    }

    @Override
    public String describe(){
        return super.describe()+"VIP Lounge";
    }




}
