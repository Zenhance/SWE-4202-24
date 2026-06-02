package model;

public class Seat {

    int row;
    int col;
    boolean isPremium;
    boolean isBooked;

public Seat(){

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

public boolean getIsPremium(){
    return isPremium;
}

public boolean getIsBooked(){
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
        return false;
    }
    else return true;

}

public String toString(){


    String trailing="#";

    if (isPremium) trailing="*";

    String res="R"+row+"C"+col+trailing;

    return res;

}







}
