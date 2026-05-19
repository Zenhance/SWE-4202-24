package data;

import model.ConcessionItem;
import model.Showtime;

public class ShowtimeBoard {
    private static final int MAX = 30;
    private Showtime[] shows = new Showtime[MAX];
    private int count = 0;

    public void add(Showtime s){
        if(count >= MAX)
            throw new IllegalArgumentException("MAX shows exceeded");
        shows[count] = s;
        count++;
    }

    public Showtime findById(int id){
        for(int i = 0; i < count; i++){
            if(id == shows[i].getId()) return shows[i];
        }
        return null;
    }

}
