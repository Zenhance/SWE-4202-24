package model;


public class Seat {
    private int row, col;
    private boolean isPremium, isBooked=false;


    public Seat(int row, int col, boolean isPremium) {
        this.row=row;
        this.col=col;
        this.isPremium=isPremium;
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
        if(isBooked)
            return true;
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


