package model;

public class StudentTicket extends AbstractTicket {

    public StudentTicket(Showtime showtime, int row, int col){
        super(showtime,row,col);
    }

    @Override
    public double subtotal() {
        double res = base*0.5;
        if (getShowtime().isPeak()) res = res*peak;
        return res;
    }

    @Override
    public String describe(){
        return "standardticket+studentticket";
    }
}
