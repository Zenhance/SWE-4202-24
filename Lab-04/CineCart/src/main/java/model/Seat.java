package model;

public class Seat {
    public int row;
    public int col;
    public boolean isPremium;
    public boolean isBooked;
//constructor
public Seat(int row,int col,boolean isPremium,boolean isBooked){
    this.row=row;
    this.col=col;
    this.isPremium=isPremium;
    this.isBooked= false;
}
//getter
public int getRow(){
    return row;
}
public int getCol(){
    return col;
}
public boolean getIsPremium(){
    return isPremium;
}
public boolean getIsBooked(){
    return isBooked;
}
public void book(){
    isBooked=true;
}

}
