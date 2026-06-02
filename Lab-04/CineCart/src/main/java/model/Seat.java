package model;

public class Seat {
    int row;
    int col;
    boolean isPremium;
    boolean isBooked;

    //Constructor
    public Seat(int row, int col,boolean isPremium) {
        this.row=row;
        this.col=col;
        this.isPremium=isPremium;
        this.isBooked=false;
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
        return this.isBooked;
    }

    public void book() {
        this.isBooked=true;
    }

    public void release() {
        this.isBooked=false;
    }

    public boolean isAvailable() {
        if(this.isBooked) {
            return false;
        }
        return true;
    }

    public String toString() {
        String seatName= "R"+row+"C"+col;
        if(this.isPremium) {
            seatName=seatName+"*";
            return seatName;
        }
        else if(this.isBooked){
            seatName=seatName+"#";
            return seatName;
        }
        else
            return null;
    }

}