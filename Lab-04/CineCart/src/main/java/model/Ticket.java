package model;

public class abstract class Ticket implements LineItem {
    private final Showtime showtime;
    private final int row;
    private final int col;
    private final double pricePaid;
}

public Ticket{
        this.showtime=showtime;
        this.row=row;
        this.col=col;
        this.pricePaid=pricePaid;}

protected double peakMultiplier(){

public Showtime getShowtime(){
    return Showtime;}
public int getRow(){
    return row;}
public int getCol(){
    return col;}
public double getPricePaid(){
    return pricePaid;}


public String toString() {
    return String.format(
            "T%d - R%dC%dC%BDT %.2f", showtime.getId(), row, col, pricePaid);}
}

