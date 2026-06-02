package model;

public class Seat {
    int row;
    int col;
    boolean isPremium;
    boolean isBooked = false;
    double basePrice;

    public Seat(int row, int col, boolean isPremium) {
        this.row = row;
        this.col = col;
        this.isPremium = isPremium;
        this.isBooked = false;
    }

    public int row() {
        return row;
    }

    public int col() {
        return col;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public double basePrice() {
        return basePrice;
    }

    public void book() {
        isBooked = true;
    }

    public void release() {
        isBooked = false;
    }

    public boolean isAvailable() {
        if (isBooked) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        if (isPremium) {
            return "*" + "R" + row + "C" + col;
        }
        if (isBooked) {
            return "#" + "R" + row + "C" + col;
        }
        else return "";
    }
}