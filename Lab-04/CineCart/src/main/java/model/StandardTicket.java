package model;

public class StandardTicket extends Ticket {
    public StandardTicket(Showtime showtime,int row, int col){
        super (showtime, row, col);
    }

    @Override
    public double subTotal(){
        double peakTime= showtime.isPeak()? 1.20:1.00;
        return basePrice*peakTime;
    }

    @Override
    public String describe(){
        return String.format("Standard Ticket T%d, R%d, C%d", showtime.getId(), row, col);
    }
}
