package model;

public class Seat {
    int row, col;
    public boolean isPremium, isBooked=false;
    Seat(int row,int col, boolean isPremium){
        this.row=row;
        this.col=col;
        this.isPremium=isPremium;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
    public void book(){
        isBooked=true;
    }
    public void release()
    {
        isBooked=false;}
    public boolean isAvilable(){
        return !isBooked;
    }

    public String toString(){
        if (isBooked&&isPremium) return String.format("R%dC%d*#",row,col);
        else if(isPremium&&!isBooked) return String.format("R%dC%d*",row,col);
        else if (!isPremium&&isBooked)return String.format("R%dC%d#",row,col);
        else return String.format("R%dC%d",row,col);
    }
}