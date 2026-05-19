package model;

public class Seat {
    private int row;
    private int col;
    private boolean isPremium;
    private boolean isBooked;

    public Seat(int row, int col, boolean isPremium, boolean isBooked){
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

    public void book(){
        isBooked = true;
    }

    public void release(){
        isBooked = false;
    }

    boolean isAvailable(){
        if(isBooked)
            return false;
        else return true;
    }

    public String toString() {
        String string = String.format("R%dC%d ", row, col);
        String flag1;
        if (isPremium) System.out.println("*");
        if(isBooked) System.out.println("#");
        return string;

    }
}

