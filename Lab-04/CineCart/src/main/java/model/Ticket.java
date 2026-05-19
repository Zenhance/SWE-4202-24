package model;

public class Ticket {
    public Showtime showtime;
    public int row;
    public int col;
    public double pricePaid;
    public Ticket(Showtime showtime,int row,int col,double pricePaid){
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
    public double getPricePaid(){
        return pricePaid;
    }
    public String toString(){
        return "T"+showtime.getId()+" - "+"R"+row+"C"+col+" @ BDT"+pricePaid;
    }
}
