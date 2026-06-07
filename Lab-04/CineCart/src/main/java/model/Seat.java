package model;

import java.util.SplittableRandom;

public class Seat {
    private int row;
    private int col;
    private boolean isPremium;
    private boolean isBooked;

    public Seat(int row, int col, boolean isPremium) {
        this.row = row;
        this.col = col;
        this.isPremium = isPremium;
        isBooked = false;
    }

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

    public boolean book() {
        if (!isBooked) {
            isBooked = true;
            return true;
        }
        return false;
    }

    public void release() {
        isBooked=false;
    }

    public boolean isAvailable() {
        if (isBooked) return false;
        return true;
    }

    public String toString() {
        String string = String.format("R%dC%d", row, col);
        if (isPremium) string = string + "*";
        if (isBooked) string = string + "#";

        return string;
    }
}
