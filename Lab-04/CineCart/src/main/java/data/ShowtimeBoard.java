package data;

import model.Showtime;

public class ShowtimeBoard {
    private Showtime[] shows = new Showtime[MAX];
    int count;
    private static final int MAX =30;
    public void add(Showtime s) {
        if (count<MAX){
        shows[count]=s;
        count++;}
    }
    public Showtime findById(int id){
        Showtime res=null;
        for (int i=0;i<count;i++){
            if (shows[i].getId()==id){
            res= shows[i];
            break;
            }
        }
        return res;
    }
    public void displayAll(){
        for (int i = 0; i < count; i++){
        System.out.println(toString());
    }
    }
}
