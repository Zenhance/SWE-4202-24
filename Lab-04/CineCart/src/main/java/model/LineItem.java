package model;

public class LineItem {
    Showtime showtime;
    int row;
    int col;
    double pricePaid;

    public LineItem()
    {
        this.showtime=showtime;
        this.row=row;
        this.col=col;
        this.pricePaid=pricePaid;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public double getPricePaid() {
        return pricePaid;
    }

    public Showtime getShowtime() {
        return showtime;
    }
    public String toString(){
        return showtime.getId()+" - R"+row+"C"+col+" @ BDT "+pricePaid;
    }

    public String describe() {
        return "premium";
    }
    public double subtotal(){
        if (showtime.isPeak()){
            return pricePaid*1.2;}
        else{
            return pricePaid;}}
}
