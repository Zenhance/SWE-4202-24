package data;

import model.Showtime;

public class ConcessionMenu {
    private Showtime[] shows;
    private int count;
    private static final int MAX = 30;

    public void add(Showtime s) {
        if (count < MAX) {
            shows[count] = s;
            count++;
        }
    }


}
