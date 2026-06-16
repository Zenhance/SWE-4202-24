package model;

public class AbstractTicket {
    private Showtime showtime;
    private int row;
    private int col;
    private double PricePaid;

    public AbstractTicket(Showtime showtime, int row, int col, double PricePaid) {
        this.showtime = showtime;
        this.row = row;
        this.col = col;
        this.PricePaid = PricePaid;
    }
    public Showtime getShowtime() {
        return showtime;
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public double getPricePaid() {
        return PricePaid;
    }
    public String toString(){
        return "T"+ showtime.getId() +" - R"+ row+ "C"+ col+ " @ BDT "+ String.format("%.2f",PricePaid);
    }
}