package model;

public class Seat {
    int row;
    int col;
    boolean isPremium;
    boolean isBooked;

    public Seat(int row,int col,boolean isPremium){
        this.row=row;
        this.col=col;
        this.isPremium=isPremium;
        this.isBooked=false;
    }

    int getRow(){
        return row;
    }
    int getCol(){
        return col;
    }
    public boolean isPremium(){
        return isPremium;
    }
    boolean isBooked(){
        return isBooked;
    }
    public void book(){
        this.isBooked=true;
    }
    void release(){
        this.isBooked=false;
    }
    public boolean isAvailable(){
        return !isBooked;
    }
    public String toString(){
        if(isPremium){
            return String.format("R%dC%d*",row,col);
        }
        else if(isBooked){
            return String.format("R%dC%d#",row,col);
        }
        else return String.format("R%dC%d",row,col);
    }
}
