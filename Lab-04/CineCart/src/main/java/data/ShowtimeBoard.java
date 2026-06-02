package data;

import model.Showtime;

public class ShowtimeBoard {
     Showtime[] shows;
     int count;
    private static final int MAX=30;

    public void add(Showtime s){
           count=0;
            shows[count]=s;
            count++;

    }
    public  Showtime findById(int id){
        for(int i=1;i<=count;i++){
            if(shows[i].getId()==id){
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




