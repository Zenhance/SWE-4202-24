package model;

public class Seat {
    int row;
    int col;
    boolean isPremium;
    boolean isBooked;

    public Seat(int row, int col, boolean isPremium, boolean isBooked) {
        this.row = row;
        this.col = col;
        this.isPremium = isPremium;
        this.isBooked = false;
    }

    public int getRow(){
        return row;
    }
    public int getCol() {
        return col;
    }
    public boolean getPremium() {
        return isPremium;
    }
    public boolean getBooked() {
        return isBooked;
    }

    public void book() {

    }

    public void release() {

    }

    public boolean isAvailable() {

    }

    public String toString() {
        String  s = "R" + row + "C" + col;
        if (isPremium) {
            s += "*";
        }
        if (isBooked) {
            s += "*";
        }
        return s;
    }
}
