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

    public Showtime findById(int id) {
        for (int i=0;i<count;i++) {
            if (id == shows[i].getId()) return shows[i];
        }

        return null;
    }

    public void displayAll() {
        for (int i=0; i<count; i++) {
            System.out.println(shows[i].toString());
        }
    }
}
