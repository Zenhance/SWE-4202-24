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

    public void displayALL(){
        for(int i = 0; i < count; i++){
            System.out.println(shows[i]);
        }
    }

    public Showtime[] getShows(){
        return shows;
    }
    public int getCount(){
        return count;
    }

}
