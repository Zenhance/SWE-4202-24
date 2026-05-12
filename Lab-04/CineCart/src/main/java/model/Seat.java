package model;

public class Seat {
    public int row;
    public int col;
    public boolean isPremium;
    public boolean isBooked;

public Seat(int row,int col,boolean isPremium,boolean isBooked){
    this.row=row;
    this.col=col;
    this.isPremium=isPremium;
    this.isBooked= false;
}


}
