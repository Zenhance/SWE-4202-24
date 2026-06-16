package model;

public  class PremiumTicket extends Ticket {
    public PremiumTicket(Showtime showtime, int row, int col){
        super(showtime, row, col);
    }

    @Override
    public double subTotal(){
        double peakTime= showtime.isPeak()? 1.20:1.00;
        return basePrice*1.30*peakTime;
    }

    @Override
    public String describe(){
        return String.format("Premium Ticket T%d, R%d, C%d", showtime.getId(), row, col);
    }




}
