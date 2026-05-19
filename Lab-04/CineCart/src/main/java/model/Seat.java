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

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    public boolean isPremium() {
        return isPremium;
    }
    public boolean isBooked(){
        return isBooked;
    }
    public boolean isAvailable(){
        if (isBooked == false){
            return true;
        }
        else {
            return false;
        }
    }
    public void book(){
        isBooked = true;
    }
    public void release(){
        isBooked = false;
    }
    public String toString(){
        String premium = "";
        String booked = "";
        if (isPremium){
            premium = "*";
        }
        if (isBooked){
            booked = "#";
        }
        return "R" + row + "C" + col + premium + booked;
    }
}
