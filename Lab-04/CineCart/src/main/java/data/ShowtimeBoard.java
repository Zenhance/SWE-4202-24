package data;

import model.Showtime;

public class ShowtimeBoard {
    private Showtime[] shows;
    private int count;
    private static final int MAX = 30;

    public ShowtimeBoard(Showtime[] shows, int count) {
        this.shows = new Showtime[MAX];
        this.count = 0;
    }

    public ShowtimeBoard() {

    }

    public void add(Showtime s) {
        if (count < MAX) {
            shows[count] = s;
            count++;
        }
    }

    public Showtime findById(int id) {
        for (Showtime s : shows) {
            if (s != null) {
                if (id == s.getId()) return s;
            }
        }
        return null;
    }

    public void displayAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(shows[i].toString());
        }
    }
}