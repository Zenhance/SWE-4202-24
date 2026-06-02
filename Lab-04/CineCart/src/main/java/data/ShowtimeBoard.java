package data;

import model.Showtime;

public class ShowtimeBoard {
    private Showtime[] shows;
    private int count;
    private static final int MAX = 30;

    public ShowtimeBoard(){
        this.shows=new Showtime[MAX];
        this.count=0;
    }
    public void add(Showtime s){


    }
    public Showtime findById(int id){
        for(int i=0;i<count;i++){
            if(shows[i].getId==id){
                return shows[i];
            }
        }return null;
    }
    public void displayAll(){
        for(int i=0;i<count;i++){
            System.out.println(shows[i].toString());
        }
    }

}
