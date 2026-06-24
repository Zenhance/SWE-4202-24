package model;

public class StandardTicket extends AbstractTicket {
    public StandardTicket(Showtime showtime, int row, int col){
        super(showtime,row,col);
    }

    @Override
    public double subtotal() {
        double res = base;
        if (getShowtime().isPeak()) res = base*peak;
        return res;
    }

    @Override
    public String describe(){
        return "standardticket";
    }

    public Showtime getShowtime() {
        return showtime;
    }
}
