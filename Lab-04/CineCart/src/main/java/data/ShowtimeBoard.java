package data;
import model.Showtime;
public class ShowtimeBoard {
    private int count;
    private static final int MAX=30;
    private Showtime[] shows;
    public ShowtimeBoard(){
        shows=new Showtime[MAX];
        count=0;
    }
    public void add(Showtime s){
        if(count<MAX){
            shows[count++]=s;
        }
    }
    public Showtime findById(int id) {
        for (int i = 0; i < count; i++) {
        if(shows[i].getId()==id){
            return shows[i];
        }
        }
        return null;
    }

}
