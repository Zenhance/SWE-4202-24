package data;

import model.Showtime;

public class ShowtimeBoard {
    public static final int MAX = 30;
    private Showtime[] shows;
    private int count;

    public ShowtimeBoard(){
        this.shows = new Showtime[MAX];
        count =0;
    }

}
