package model;

public class Ticket {
    private Showtime showtime;
    private int row;
    private int col;
    private double base;

    public Ticket(Showtime showtime, int row, int col) {
        this.showtime = showtime;
        this.row = row;
        this.col = col;
        this.base = showtime.getMovie().getBasePrice();
    }

    public Showtime getShowtime(){return showtime;}
    public int getRow(){return row;}
    public int getCol(){return col;}
    public double isPeak() {
        if(showtime.isPeak()) return 1.20;
        else return 1.00;
    }


    public String toString() {
        return (showtime.getId()+" "+"-"+" "+"R"+row+"C"+col+" "+"@"+" "+"BDT"+pricePaid);
    }




}
