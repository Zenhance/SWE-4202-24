package model;

public class Seat {
    private int row;
    private int col;
    private boolean isPrime;
    private boolean isBooked;


    public Seat(int row,int col,boolean isPrime,boolean isBooked){
        this.row=row;
        this.col=col;
        this.isPrime=isPrime;
        this.isBooked=false;
    }

    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }

    public boolean getIsPrime(){
        return isPrime;
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
        };
        else if(!isBooked){return false;}
    }
    public String toString(){
        String result= "R"+ row + "C"+ col;
    }


}
