package model;

public class Seat {
    private int row,col;
    private boolean isPremium;
    private boolean isBooked;
    public Seat(int row,int col, boolean isPremium){
        this.row=row;
        this.col=col;
        this.isPremium =isPremium;
        this.isBooked =false;
    }

    public int getRows(){
        return row;
    }
    public int getCols(){
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

        return !isBooked;
    }
    public String toString() {
        String s="R"+row+"C"+col;
        if(isPremium) s+="*";
        if(isBooked) s+= "#";
        return s;
    }

}

