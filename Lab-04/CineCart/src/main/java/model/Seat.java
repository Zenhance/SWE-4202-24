package model;

public class Seat {

    private int row;
    private int col;
    boolean isPremium;
    private boolean isBooked;

    public Seat(int row, int col, boolean isPremium,
                boolean isBooked) {
        this.row = row;
        this.col = col;
        this.isPremium = isPremium;
        this.isBooked = false;

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
        isBooked = true;
    }

    public void release() {
        isBooked = false;
    }

    public boolean isAvailable() {
        return !isBooked;
    }
}



