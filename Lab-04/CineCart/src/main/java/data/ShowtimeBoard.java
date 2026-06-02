package data;

import model.Showtime;

public class ShowtimeBoard {
    Showtime[] shows;
    int count;
    private static final int MAX =30;
    public void add(Showtime s) {
        shows[count]=s;
        count++;
    }
    public Showtime findbyId(int id){
        for (int i=0;i<MAX;i++){
            if (shows[i].getId()==id);
            return shows[i];
        }
        return null;
    }
    public void displayAll(){
        System.out.println(toString());
    }
}
