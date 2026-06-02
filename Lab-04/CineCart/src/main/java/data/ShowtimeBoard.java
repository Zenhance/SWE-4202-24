package data;

import model.Showtime;

public class ShowtimeBoard {
    private int count=0;
    private static final int MAX = 30;
    private Showtime[] shows = new Showtime[MAX];

    public void add(Showtime s){
        if (count <MAX ){
            shows[count] =s ;
            count++;
        }
    }

    public Showtime findById(int id){
        Showtime res = null;
        for(int i=0;i<count;i++){

            if(id == shows[i].getId()){
                res=shows[i];
                break;
            }

        } return res; }


    public void displayAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(shows[i].toString())
        }
    } }
