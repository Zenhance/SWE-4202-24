package model;

public class Seat {
    int row;
    int col;
    boolean isPremimum;
    boolean isBooked;
    public Seat(int row, int col, boolean isPremium){
        this.row=row;
        this.col=col;
        this.isBooked=false;
        this.isPremimum=isPremium;

    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }

    public boolean isBooked() {
        return this.isBooked;
    }

    public boolean isPremium() {
        return this.isPremimum;
    }
    public void book(){
        this.isBooked=true;
    }
    public void release(){
        this.isBooked=false;
    }
    public boolean isAvailable(){
            if(this.isBooked){
                return false;
            }
            return true;
    }
    public String toString(){
           if(this.isPremimum){
               return "R3C5"+"*";
           }
         else  if(this.isBooked){
             return "R3C5"+"#";
           }
         return null;
    }
}
