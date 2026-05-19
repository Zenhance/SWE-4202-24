package data;

import model.ConcessionItem;
import model.Showtime;

public class ShowtimeBoard {
    private static final int MAX = 30;
    private Showtime[] shows = new Showtime[MAX];
    private int count = 0;

    public void add(Showtime s){
        shows[count] = s;
        count++;
    }

}
