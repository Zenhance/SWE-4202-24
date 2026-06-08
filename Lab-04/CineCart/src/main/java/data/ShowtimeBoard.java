package data;


import model.Showtime;

public class ShowtimeBoard {
    private Showtime[] shows;
    private int count;
    private static final int MAX = 30;

    public ShowtimeBoard(){
        shows = new Showtime[MAX];
    }


    public void add(Showtime s){
        if(count < MAX){
            shows[count++] = s;
        }
    }



}