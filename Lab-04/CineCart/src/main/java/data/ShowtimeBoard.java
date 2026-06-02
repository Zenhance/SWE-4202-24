package data;

import model.Showtime;

public class ShowtimeBoard {
    private Showtime[] shows;
    private int count;
    private static final int MAX=30;

    public Showtime[] getShows() {
        return shows;
    }

    public int getCount() {
        return count;
    }

    public static int getMAX() {
        return MAX;
    }
}



