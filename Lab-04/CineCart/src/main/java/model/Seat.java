package model;

public class Seat {
    int row;
    int col;
    boolean isPremimum;
    boolean isBooked;
    public Seat(int row, int col, boolean isPremium, boolean isBooked){
        this.row=row;
        this.col=col;
        this.isBooked=isBooked;
        this.isPremimum=isPremium;

    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public boolean isPremimum() {
        return isPremimum;
    }

}
