package model;

public class Seat {
    private int row;
    private int col;
    private boolean isPremium;
    private boolean isBooked;

    public Seat(int row, int col, boolean isPremium) {
        this.row = row;
        this.col = col;
        this.isPremium = isPremium;
        this.isBooked = false;
    }

    // implementing the getter methods
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public boolean isBooked() {
        return isBooked;
    }

    // Implementing other functions
    public void book() {
        isBooked = true;
    }

    public void release() {
        isBooked = false;
    }

    public boolean isAvailable() {
        if (isBooked) {
            return false;
        } else return true;
    }

    @Override
    public String toString() {
        String trailing = "#";

        if (isPremium) trailing = "*";
        return String.format("R%d C%d %s", row, col, trailing);
    }
}