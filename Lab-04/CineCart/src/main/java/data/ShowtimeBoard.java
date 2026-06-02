package data;

import model.Showtime;

public class ShowtimeBoard {
    private Showtime[] shows;
    private int count;
    private static final int MAX = 30;

    public ShowtimeBoard(){
        Showtime[] showtime = new Showtime[MAX];
        this.count = 0;
    }

    public void add(Showtime s){
        if(count < MAX){
            shows[count] = s;
            count++;
        }
    }

    public Showtime findById(int id){
        Showtime result = null;

        for(int i = 0; i < MAX; i++){
            if(shows[i].getId() == id){
                result = shows[i];
                break;
            }
        }
        return result;
    }

    public void displayALL(){
        for(int i = 0; i < MAX; i++){
            System.out.println(shows[i].toString());
        }
    }
}