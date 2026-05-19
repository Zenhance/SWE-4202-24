package model;

public class Ticket
{
    private Showtime showtime;
    private int row;
    private int col;
    private double pricePaid;

    public Ticket(Showtime showtime, int row, int col, double pricePaid)
    {
        this.showtime = showtime;
        this.row = row;
        this.col = col;
        this.pricePaid = pricePaid;
    }

    public String toString()
    {
        return "T"+showtime.getId()+" - "+"R"+row+"C"+col+" @ BDT "+String.format("%.2f",pricePaid);
    }
}