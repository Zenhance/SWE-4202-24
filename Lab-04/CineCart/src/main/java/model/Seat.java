package model;

public class Seat {
    int row;
    int col;
    boolean isPremium;
    boolean isBooked;
    public Seat(int row, int col, boolean isPremium){
        this.row = row;
        this.col = col;
        this.isPremium = isPremium;
        isBooked = false;
    }
    public void book(){
      isBooked = true;
    }
    public void release(){
      isBooked = false;
    }
    public boolean isAvailable(){
        return !isBooked;
    }
    public boolean isPremium(){
        return isPremium;
    }
    public String toString(){
        if(isPremium){
           return "R"+row+"C"+col+ "*";
       }
       else {
            return "R"+row+"C"+col+ "#";
        }
    }

}
