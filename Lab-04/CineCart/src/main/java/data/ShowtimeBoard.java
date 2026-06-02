package data;

import model.Showtime;

public class ShowtimeBoard {
    private Showtime[] shows;
    private int count;
    private static final int MAX=30;

    public void add(Showtime s){
        shows[count]=s;
        count ++;
    }
    public Showtime findByID(int id){
        for(int i=0;i<count;i++){
            if(shows[i].getId()==id){
                return shows[i];
            }
        }
        return null;
    }
    public void displayAll(){
        for(int i=0;i<count;i++){
            shows[i].toString();
        }
    }


}
