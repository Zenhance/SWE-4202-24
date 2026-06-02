package model;

public class Seat {
    int row;
    int col;
    boolean isPremium;
    boolean isBooked;

    //Constructor
    Seat(int row, int col,boolean isPremium) {
        this.row=row;
        this.col=col;
        this.isPremium=isPremium;
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
        isBooked=true;
    }

    public void release() {
        isBooked=false;
    }

    public boolean isAvailable() {
        return isBooked;
    }

    public String toString() {
        String seatName= "R"+row+"C"+col;
        if(isPremium) {
            seatName=seatName+"*";
        }
        else {
            seatName=seatName+"#";
        }

        return seatName;
    }

}