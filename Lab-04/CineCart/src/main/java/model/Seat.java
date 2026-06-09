package model;


public class Seat {
    private final int row, col;
    private final boolean isPremium;
    private boolean isBooked;


    public Seat(int row, int col, boolean isPremium) {
        this.row=row;
        this.col=col;
        this.isPremium=isPremium;
        this.isBooked=false;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public boolean isBooked() {
        return isBooked;
    }
    public boolean isPremium() {
        return isPremium;
    }

    public boolean book() {
        if(!isBooked) {
            isBooked=true;
            return true;
        }
        return false;
    }
    public void release(){
        isBooked=false;
    }
    public boolean isAvailable(){
        return !isBooked;
    }
    public String toString(){
        return "R"+row+"C"+col+(isPremium?"*":"#");
    }


}


