package model;

public class Seat {
    private final int row;
    private final int col;
    private boolean isBooked = false;
    private final boolean isPremium;

    public Seat(int row, int col, boolean isPremium) {
        this.row = row;
        this.col = col;
        this.isPremium = isPremium;
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

    public boolean isAvailable(){
        return (isBooked==true) ? false : true ;}  // just trying ternary

    public boolean book(){
        boolean temp = isBooked;
        isBooked = true;
        return (temp==true) ? false : true;
    }

    public void release(){
        isBooked = false;}

    public String toString(){
        String out = String.format("R%dC%d", row, col);
        if(isPremium) {out = out + "*";}
        if(isBooked) {out = out + "#";}
        return out;
    }
}