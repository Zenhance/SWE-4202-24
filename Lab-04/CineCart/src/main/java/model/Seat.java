package model;

public class Seat {
    private int row;
    private int col;
    private boolean isPremium;
    private boolean isBooked;

    public Seat(int row, int col, boolean isPremium){
        this.row=row;
        this.col=col;
        this.isPremium=isPremium;
        this.isBooked=false;
    }

    public int getRow() {
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    public boolean isPremium(){
        return this.isPremium;
    }

    public boolean isBooked() {
        return this.isBooked;
    }

    public boolean book(){
        if(!this.isBooked){
            this.isBooked=true;
        }

        return false;
    }
    public void release(){
        this.isPremium=true;
        this.isBooked=false;
    }

    public boolean isAvailable(){
        boolean x=false;
        if(!this.isBooked){
            x=true;

        }
        else if(this.isBooked){
            x=false;
        }
        return x;
    }
    public String toString(){
        char x=' ', y=' ';
        if(isPremium){
            x='*';
        }
        if(isBooked){
            y='#';
        }
        return "RC35"+x+y;


    }



}
