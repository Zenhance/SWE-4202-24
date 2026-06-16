package model;

public abstract class AbstractTicket extends LineItem{

   protected Showtime showtime;
   protected int row;
    protected int col;
    protected double pricePaid;


public AbstractTicket(Showtime showtime, int row, int col, double pricePaid){

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

    String res=String.format("T%d - R%dC%d @ BDT %.2f",showtime.getId(),row,col,pricePaid);
   return res;
}  }


