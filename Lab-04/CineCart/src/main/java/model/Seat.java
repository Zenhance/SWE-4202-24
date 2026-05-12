package model;

public class Seat {
    public int row;
    public int col;
    public boolean isPremium;
    public boolean isBooked;
    public Seat(int row,int col,boolean isPremium){
        this.row=row;
        this.col=col;
        this.isPremium=isPremium;
        isBooked=false;
    }
    public int getrow(){
        return row;
    }
    public int getcol(){
        return col;
    }
    public boolean getisPremium(){
        return isPremium;
    }
    public boolean getisBooked(){
        return isBooked;
    }
}
