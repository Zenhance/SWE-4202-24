package model;

public class Seat {
    int row, col;
    public boolean isPremium, isBooked=false;
    public Seat(int row, int col, boolean isPremium){
        this.row=row;
        this.col=col;
        this.isPremium=isPremium;
    }


    public void book(){
        isBooked=true;
    }
    public void release()
    {
        isBooked=false;}
    public boolean isAvailable(){
        return !isBooked;
    }

    public String toString(){
        if (isBooked&&isPremium) return String.format("R%dC%d*#",row,col);
        else if(isPremium&&!isBooked) return String.format("R%dC%d*",row,col);
        else if (!isPremium&&isBooked)return String.format("R%dC%d#",row,col);
        else return String.format("R%dC%d",row,col);
    }

    public boolean isPremium() {
        return isPremium;
    }

    public boolean isBooked() {
        return isBooked;
    }
}