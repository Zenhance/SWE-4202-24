package data;

import model.ConcessionItem;
import model.Showtime;

public class ShowtimeBoard {
    private Showtime[] shows;
    private int count;
    private static final int MAX = 30;

    public ShowtimeBoard() {
        this.shows = new Showtime[MAX];
        this.count = 0;
    }

    public void add(Showtime s) {
        if (count<MAX) {
            shows[count] = s;
            count++;
        }
    }
}
