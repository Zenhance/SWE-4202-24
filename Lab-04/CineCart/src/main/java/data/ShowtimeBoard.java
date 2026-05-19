package data;
import model.Showtime;

public class ShowtimeBoard {
    static final int MAX = 30; //Constant

    private final Showtime[] shows;
    private int count;

    public ShowtimeBoard() {
        this.shows = new Showtime[MAX];
    }

    public void add(Showtime s){
        if(count < MAX){
            shows[count] = s;
            count++;
        }
    }

    public Showtime findById(int id){
        for(int i=0;i<count;i++){
            if(shows[i].getId()==id) return shows[i];
        }
        return null;
    }

    public void displayAll(){
        for(int i=0;i<count;i++){
            System.out.println(shows[i].toString());
        }
    }
}
