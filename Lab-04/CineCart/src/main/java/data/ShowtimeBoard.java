package data;
import model.Showtime;
public class ShowtimeBoard {

private Showtime[] shows;

private int count;

private static final int MAX = 30;



void add(Showtime s) {
    int count = 0;
    for(int i = 0; i < MAX;i++){
        shows[count] = s;
            count++;
        }
    }
}










}
