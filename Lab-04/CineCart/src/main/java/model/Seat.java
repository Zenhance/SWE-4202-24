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
    }
    void book(){
      isBooked = true;
    }
    void release(){
      isBooked = false;
    }
    boolean isAvailable(){
         return true;
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
