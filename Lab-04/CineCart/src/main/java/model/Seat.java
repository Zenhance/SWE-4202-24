package model;

public class Seat {
    int row;
    int col;
    boolean isPremium;
    boolean isBooked;

    public Seat(int row, int col, boolean isPremium)
    {
        this.row=row;
        this.col=col;
        this.isPremium=isPremium;
        this.isBooked=false;
    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    public boolean getIsPremium(){
        return this.isPremium;
    }
    public boolean getIsBooked(){return this.isBooked; }

    public void book(){
        isBooked=true;
    }

    public void release(){
        isBooked=false;
    }

    public boolean isAvailable(){
        if(isBooked==false){
            return true;
        }
        return false;
    }

    public String toString(){
        String seat="R"+row+"C"+col;
        if(isPremium){
            seat+="*";
        }
        if(isBooked){
            seat+="#";
        }
        return seat;
    }

}
