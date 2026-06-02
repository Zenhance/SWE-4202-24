package data;

import model.Showtime;

public class ShowtimeBoard {
     Showtime[] shows;
     int count;
    private static final int MAX=30;
    public ShowtimeBoard(){
        shows=new Showtime[MAX];
        count=0;
    }
    public void add(Showtime s){
        if(count<=MAX){
            shows[count]=s;
            count++;
        }
    }
    public  Showtime findById(int id){
        for(int i=1;i<=count;i++){
            if(shows[i].getId()==id){
                return shows[i];
            }
        }
        return null;
    }

}




