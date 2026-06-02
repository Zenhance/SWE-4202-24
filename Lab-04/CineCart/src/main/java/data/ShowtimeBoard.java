package data;

import model.Showtime;

public class ShowtimeBoard {
    private int count=0;
    private static final int MAX = 30;
    private Showtime[] shows = new Showtime[MAX];

    public void add(Showtime s){
        if (count <MAX ){
            shows[count] =s ;
            count++
        }
    }




}
