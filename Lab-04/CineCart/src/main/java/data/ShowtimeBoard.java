package data;

import model.Showtime;

public class ShowtimeBoard {
    private Showtime[] shows;
    private int count=0;
    private static final int MAX=30;

    public Showtime[] getShows() {
        return shows;
    }



    public static int getMAX() {
        return MAX;
    }


    public void add(Showtime s){
        if(count>= MAX){
            return;
        }
        shows[count]=s;
        count++;
    }
    public Showtime findById(int id){
        for(int i=0;i<count;i++){
            if(shows[i].getId() == id){
                return shows[i];
            }

        }
        return null;
    }
    public void displayAll(){
        for(int i=0;i<count;i++){
            System.out.println(shows[i]);
        }
    }


}




