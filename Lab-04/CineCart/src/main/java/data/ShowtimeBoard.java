package data;

import model.ConcessionItem;
import model.Showtime;

public class ShowtimeBoard {
    private Showtime[] shows=new Showtime[MAX];
    private int count=0;
    private static final int MAX=30;



    public void add(Showtime s){
        shows[count]=s;
        count ++;
    }
    public Showtime findById(int id){
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
