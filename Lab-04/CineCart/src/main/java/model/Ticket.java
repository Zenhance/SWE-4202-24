package model;

public class Ticket {
    private Showtime showtime;
    private int row;
    private int col;
    private double pricePaid;
    private int id;

    public Ticket(Showtime showtime, int row, int col, double pricePaid){
        this.id = id;
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
    public int getId(){return this.id;}
    public double getPricePaid(){
        return this.pricePaid;
    }
    public String toString(){
        return "T"+showtime.getId()+" - R"+row+"C"+col+" @ BDT "+pricePaid;
    }
}
