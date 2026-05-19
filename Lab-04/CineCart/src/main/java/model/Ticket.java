package model;

public class Ticket {
    private Showtime showtime;
    private int row;
    private int col;
    private double pricePaid;

    public Ticket(){
        this.showtime=showtime;
        this.row=row;
        this.col=col;
        this.pricePaid=pricePaid;
    }

    public Showtime getShowtime(){
        return showtime;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public double getpricePaid(){
        return pricePaid;
    }

    public String toString(){
        return "T" + showtime.getId() + " -R" + row + "C" + col + " @ BDT " + String.format("%.2f",pricePaid);
    }
}
