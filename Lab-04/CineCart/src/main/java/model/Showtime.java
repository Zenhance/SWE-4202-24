package model;
import model.Hall;

public class Showtime {
    private int id;
    private Movie movie;
    private Hall hall;
    private int startHour;
    private String dateTag;


    public Showtime(int id, Movie movie, Hall hall, int startHour,
                    String dateTag){
        this.id = id;
        this.hall = hall;
        this.startHour = startHour;
        this.dateTag = dateTag;

    }
}