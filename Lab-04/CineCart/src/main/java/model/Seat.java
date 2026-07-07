package model;

public class Seat {
    private int row;
    private int col;
    public boolean isPremium;
    private boolean isBooked;


    public Seat(int row,int col,boolean isPremium,boolean isBooked){
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
        return !isBooked;
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


    public boolean isPremium() {
        return this.isPremium;
    }
}
