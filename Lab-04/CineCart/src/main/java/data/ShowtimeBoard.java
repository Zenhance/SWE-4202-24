package data;

import model.Showtime;

public class ShowtimeBoard {
    private Showtime[] shows;
    private int count;
    private static final int MAX = 30;

    public void add(Showtime s){
        if (count < MAX){
            shows[count] = s;
        }
    }

    public Showtime findById(int id){
        Showtime res = null;

        for (Showtime s : shows){
            if(id == s.getId()){
                res = s;
                break;
            }
        }

        return res;
    }


    public void displayAll(){
        for (int i = 0; i < count; i++){
            System.out.println(shows[i].toString());
        }
    }
}
