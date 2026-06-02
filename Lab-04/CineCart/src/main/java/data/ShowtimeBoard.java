package data;

import model.Showtime;

public class ShowtimeBoard {
    private Showtime[] shows;
    private int count;
    private static final int MAX = 30;

    public void add(Showtime s){
        if(count < MAX){
            shows[count++] = s;
        }
    }

    public Showtime findById(int id){
        for(int i = 0; i < count; i++){
            if(shows[i].getId() == id){
                return shows[i];
            }
        }
        return null;
    }

    

}
