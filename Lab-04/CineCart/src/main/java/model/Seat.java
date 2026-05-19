package model;

public class Seat {
    private int row;
    private int col;
    private boolean isPremium;
    private boolean isBooked;


    public Seat(int row,int col,boolean isPrime,boolean isBooked){
        this.row=row;
        this.col=col;
        this.isPremium=isPremium;
        this.isBooked=false;
    }

    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }

    public boolean getIsPrime(){
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
        if(isBooked){
            return true;
        }
        else {return false;}
    }
    public String toString(){
         String seatName= "R"+ row + "C"+ col;
         if(isPremium){
            seatName+="*";
         }
         else if(!isPremium){
             seatName+="#";
         }
         return seatName;
    }


}
