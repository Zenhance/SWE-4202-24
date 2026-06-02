package data;

import model.Showtime;

public class ShowtimeBoard {
    private Showtime[] shows;
    private int count;
    public static final int MAX=30;

    public ShowtimeBoard(){
        shows=new Showtime[MAX];
        count=0;
    }
    public Showtime findById(int id) {
        for (int i = 0; i < count; i++) {
            if (shows[i].getId() == id) {
                return shows[i];
            }
        }
        return null; // not found
    }
    public void add(Showtime s) {
        if (count < MAX) {
            shows[count] = s;
            count++;
        }
    }
    public void displayAll() {
        System.out.println("=== Available Showtimes ===");
        for (int i = 0; i < count; i++) {
            System.out.println(shows[i]);
        }
    }
}

