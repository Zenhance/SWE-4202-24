package model;

public class Ticket {
    private final Showtime showtime;
    private final int row;
    private final int col;
    private final double pricePaid;

    public Ticket(Showtime showtime, int row, int col, double pricePaid){
        this.showtime = showtime;
        this.row = row;
        this.col = col;
        this.pricePaid = pricePaid;
    }

    public Showtime getShowtime(){
        return this.showtime;
    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    public double getPricePaid(){
        return this.pricePaid;
    }
    public String toString(){
        return "T"+showtime.getId()+" - R"+row+"C"+col+" @ BDT "+pricePaid;
    }
}
