package data;

import model.Showtime;

public class ShowtimeBoard {
    private Showtime[] shows;
    private int count;
    private static final int MAX = 30;

    public ShowtimeBoard(){
        shows = new Showtime[MAX];
        count = 0;
    }

    public void add(Showtime s){
        if (count < MAX){
            shows [count] = s;
            count ++;
        }
    }

    public Showtime findById(int id){
        if (id <= 0)
            return null;
        for (int i = 0; i<count; i++){
            if(id == shows[i].getId())
                return shows[i];
        }
    return null;
    }


}
