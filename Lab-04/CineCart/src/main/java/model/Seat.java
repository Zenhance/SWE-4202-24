package model;

public class Seat {
    int row;
    int col;
    boolean isPremium;
    boolean isBooked;

    //Constructor
    Seat(int row, int col,boolean isPremium, boolean isBooked) {
        this.row=row;
        this.col=col;
        this.isPremium=isPremium;
        this.isBooked=isBooked;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean getIsPremium() {
        return isPremium;
    }

    public boolean getIsBooked() {
        return isBooked;
    }

    public void book() {

    }

    public void release() {

    }

    public boolean isAvailable() {
        return isBooked;
    }

    public String toString() {

    }


}
