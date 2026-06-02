package data;
import model.Showtime;

public class ShowtimeBoard {
    Showtime[] shows;
    int count;
    public static final int MAX = 30;

    public void add(Showtime s) {
        if(count<MAX) {
            shows[count]=s;
            count++;
        }
    }

    public Showtime findById(int id) {
        for(int i=0;i<count;i++) {
            if(shows[i].getId()==id) {
                return shows[i];
            }
            else {
                return null;
            }
        }
    }
}
