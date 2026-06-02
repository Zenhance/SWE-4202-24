package model;

public class Seat {
    public int row;
    public int col;
    public boolean isPremium;
    public boolean isBooked;
    public Seat(int row,int col,boolean isPremium){
        this.row=row;
        this.col=col;
        this.isPremium=isPremium;
        isBooked=false;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public boolean isPremium(){
        return isPremium;
    }
    public boolean isBooked(){
        return isBooked;
    }
    public void book(){
        isBooked=true;
    }
    public void release(){
        isBooked=false;
    }
    public boolean isAvailable(){
        return isBooked=false;
    }
    public String toString(){
     String res="R"+row+"C"+col;
     if(isPremium){
         return "*";
     }
     else if(isBooked){
         return "#";
     }
     return res;
    }
}
