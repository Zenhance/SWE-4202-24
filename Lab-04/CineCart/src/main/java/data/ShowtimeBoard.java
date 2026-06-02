package data;

import model.Showtime;

public class ShowtimeBoard {
    private Showtime[] shows;
    private int count;
    private static final int MAX=30;

    public void add(Showtime s){
        shows[count]=s;
        count ++;
    }


}
