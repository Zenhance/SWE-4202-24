package data;

import model.Showtime;

public class ShowtimeBoard {
     Showtime[] shows;
     int count;
    private static final int MAX=30;
    public ShowtimeBoard(){
        shows=new Showtime[MAX];
        count=0;
    }
    public void add(Showtime s){
        if(count<=MAX){
            shows[count]=s;
            count++;
        }
    }
}




